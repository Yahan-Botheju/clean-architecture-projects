package lk.clean.architecture.cart.system.ex02.modules.order.domain.modules;

import lk.clean.architecture.cart.system.ex02.modules.order.domain.enums.OrderStatus;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
public class Order {
    private final UUID orderId;
    private final UUID userId;
    private double totalAmount;
    private OrderStatus orderStatus;
    private List<OrderItem> orderItems;
    private LocalDateTime createdAt;

    public Order(UUID orderId, UUID userId, double totalAmount, OrderStatus orderStatus, List<OrderItem> orderItems, LocalDateTime createdAt) {
        this.orderId = orderId;
        this.userId = userId;
        this.totalAmount = totalAmount;
        this.orderStatus = orderStatus;
        this.orderItems = orderItems;
        this.createdAt = createdAt;
    }

    /* __FACTORY_METHOD__ */
    public static Order createNewOrder(
            UUID userId,
            double totalAmount,
            OrderStatus orderStatus,
            List<OrderItem> orderItems,
            LocalDateTime createdAt
    ) {
        return new Order(
                UUID.randomUUID(),
                userId,
                totalAmount,
                orderStatus,
                orderItems,
                createdAt
        );
    }



    /* __DOMAIN_LOGIC__ */

    //create order
    public void createOrder() {
        //check order item is empty
        if(this.orderItems.isEmpty()){
            throw new IllegalArgumentException("Order items cannot be empty");
        }
        //set all subtotal into total amount
        this.totalAmount = orderItems.stream().mapToDouble(OrderItem::getItemSubTotal).sum();
        //set order status as pending
        this.orderStatus = OrderStatus.PENDING;
    }
}
