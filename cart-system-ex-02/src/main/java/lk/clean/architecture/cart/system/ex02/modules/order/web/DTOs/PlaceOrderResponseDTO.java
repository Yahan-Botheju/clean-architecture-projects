package lk.clean.architecture.cart.system.ex02.modules.order.web.DTOs;

import lk.clean.architecture.cart.system.ex02.modules.order.domain.enums.OrderStatus;
import lk.clean.architecture.cart.system.ex02.modules.order.domain.modules.OrderItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceOrderResponseDTO {
    private UUID orderId;
    private UUID userId;
    private double totalAmount;
    private OrderStatus orderStatus;
    private List<OrderItem> orderItems;
    private LocalDateTime createdAt;
}
