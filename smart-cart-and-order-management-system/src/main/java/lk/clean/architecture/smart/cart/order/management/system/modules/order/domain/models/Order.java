package lk.clean.architecture.smart.cart.order.management.system.modules.order.domain.models;

import lk.clean.architecture.smart.cart.order.management.system.modules.order.domain.enums.OrderStatus;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public class Order {
    private final UUID orderId;
    private final UUID customerId;
    private final UUID cartId;
    private OrderStatus orderStatus;
    private BigDecimal totalAmount;
    private LocalDateTime createdAt;
    private LocalDateTime cancelledAt;

    private List<OrderItem> orderItem;

    public Order(UUID orderId, UUID customerId, UUID cartId, OrderStatus orderStatus, BigDecimal totalAmount, LocalDateTime createdAt, LocalDateTime cancelledAt, List<OrderItem> orderItem) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.cartId = cartId;
        this.orderStatus = orderStatus;
        this.totalAmount = totalAmount;
        this.createdAt = createdAt;
        this.cancelledAt = cancelledAt;
        this.orderItem = orderItem;
    }

    /* __FACTORY_METHOD__ */
    public static Order CreateNewOrder(
            UUID customerId,
            UUID cartId,
            BigDecimal totalAmount,
            LocalDateTime createdAt,
            LocalDateTime cancelledAt,
            List<OrderItem> orderItem
    ) {
        return new Order(
                UUID.randomUUID(),
                customerId,
                cartId,
                OrderStatus.CREATED,
                totalAmount,
                createdAt,
                cancelledAt,
                orderItem
        );
    }

    /* __DOMAIN_LOGICS__ */


    //create order
    public void createOrder(LocalDateTime currentTime) {
        //check order, item is empty
        if(this.orderItem.isEmpty()) {
            throw new IllegalStateException("Cannot proceed order due to orderItem is empty");
        }
        this.orderItem.forEach(OrderItem::calculateSubTotalOfOrderItem);
        this.orderStatus = OrderStatus.CREATED;
        this.createdAt = currentTime;
    }

    //get total amount
    public void orderTotalCalculate(){
        this.totalAmount = orderItem.stream().map(OrderItem::getSubTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    //complete order
    public void completeOrder() {
        if(this.orderStatus != OrderStatus.CREATED) {
            throw new IllegalStateException("Cannot complete order due to order is not CREATED");
        }
        this.orderStatus = OrderStatus.COMPLETED;
    }

    //cancel order
    public void cancelOrder(LocalDateTime currentTime) {
        if(this.orderStatus == OrderStatus.CANCELLED || this.orderStatus == OrderStatus.COMPLETED) {
            throw new IllegalStateException("Order cannot be cancelled due to order is not in required state");
        }
        this.cancelledAt = currentTime;
        this.orderStatus = OrderStatus.CANCELLED;
    }
}
