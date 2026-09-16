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
}
