package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.usecase;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.api.InventoryModuleApi;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.modules.Order;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.repositories.OrderRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class PlaceOrderUseCaseImpl implements PlaceOrderUseCase{

    //inject required dependencies
    private final OrderRepository orderRepository;
    private final InventoryModuleApi inventoryModuleApi;

    public PlaceOrderUseCaseImpl(
            OrderRepository orderRepository,
            InventoryModuleApi inventoryModuleApi
    ) {
        this.orderRepository = orderRepository;
        this.inventoryModuleApi = inventoryModuleApi;
    }

    //place new order
    @Override
    public Order placeOrder(
            UUID customerId,
            UUID productId,
            int requestQuantity
    ){
        //check customer existence
        if(!orderRepository.customer_existsById(customerId)){
            throw new ResourceNotFoundException("customer not found");
        }
        //create time
        LocalDateTime currentTime = LocalDateTime.now();

        //use inventory domain components
        inventoryModuleApi.stockReservation(productId,requestQuantity,currentTime);

        BigDecimal totalPrice = inventoryModuleApi.getUnitPrice(productId);
        //use static method for create new model
        Order newOrder = Order.createNewOrder(customerId, productId, requestQuantity, totalPrice);
        //use domain logic
        newOrder.createOrderCheck(currentTime);

        return newOrder;
    }
}
