package lk.clean.architecture.cart.system.ex02.modules.order.usecase;

import lk.clean.architecture.cart.system.ex02.modules.cart.api.CartQueryApi;
import lk.clean.architecture.cart.system.ex02.modules.catalog.api.CatalogStockDeductApi;
import lk.clean.architecture.cart.system.ex02.modules.order.domain.modules.Order;
import lk.clean.architecture.cart.system.ex02.modules.order.domain.modules.OrderItem;
import lk.clean.architecture.cart.system.ex02.modules.order.domain.repository.OrderRepository;
import lk.clean.architecture.cart.system.ex02.modules.order.usecase.records.PlaceOrderCommand;
import lk.clean.architecture.cart.system.ex02.modules.order.usecase.records.PlaceOrderResult;
import lk.clean.architecture.cart.system.ex02.modules.shared_domain.cart.api_records.CartDetailsResult;

import java.time.LocalDateTime;
import java.util.List;


public class PlaceOrderUseCaseImpl implements PlaceOrderUseCase {

    //inject required dependencies
    private final OrderRepository orderRepository;
    private final CartQueryApi cartQueryApi;
    private final CatalogStockDeductApi catalogStockDeductApi;


    public PlaceOrderUseCaseImpl(
            OrderRepository orderRepository,
            CartQueryApi cartQueryApi,
            CatalogStockDeductApi catalogStockDeductApi

    ) {
        this.orderRepository = orderRepository;
        this.cartQueryApi = cartQueryApi;
        this.catalogStockDeductApi = catalogStockDeductApi;

    }

    //place an order
    @Override
    public PlaceOrderResult execute(PlaceOrderCommand placeOrderCommand) {
        //get user related to id
        CartDetailsResult userCartDetails = cartQueryApi.getCartByUserId(placeOrderCommand.userId());

        //check user id or cart items are empty
        if(userCartDetails.userId() == null || userCartDetails.cartItems().isEmpty()){
            throw new IllegalStateException("Cannot place order with an empty cart");
        }

        //deduct items total
        userCartDetails.cartItems().forEach(cartItem ->
            catalogStockDeductApi.deductStock(cartItem.getProductId(), cartItem.getQuantity())
        );

        //map cart items into order list
        List<OrderItem> orderItems = userCartDetails.cartItems().stream()
                .map(cartItem -> new OrderItem(
                        cartItem.getProductId(),
                        cartItem.getProductName(),
                        cartItem.getUnitPrice(),
                        cartItem.getQuantity()
                )).toList();

        LocalDateTime currentTime = LocalDateTime.now();

        //create new order
        Order placeNewOrder = Order.createOrder(
                placeOrderCommand.userId(),
                orderItems,
                currentTime
        );

        //confirm order
        placeNewOrder.confirmOrder();

        Order savedOrder = orderRepository.save(placeNewOrder);
        //clean cart
        cartQueryApi.clearCartByUserId(placeOrderCommand.userId());

        return new PlaceOrderResult(
                savedOrder.getOrderId(),
                savedOrder.getUserId(),
                savedOrder.getTotalAmount(),
                savedOrder.getOrderStatus(),
                savedOrder.getOrderItems(),
                savedOrder.getCreatedAt()
        );
    }
}
