package lk.clean.architecture.cart.system.ex02.modules.order.infrastructure.persistence.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lk.clean.architecture.cart.system.ex02.modules.order.domain.enums.OrderStatus;
import lk.clean.architecture.cart.system.ex02.modules.order.domain.modules.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "orders")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    @Column(name = "order_id", nullable = false, unique = true)
    private UUID orderId;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(name = "total_amount", nullable = false)
    private double totalAmount;

    @Column(name = "order_status", nullable = false)
    private OrderStatus orderStatus;

    @Column(name = "order_item", nullable = false)
    private List<OrderItem> orderItems;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
