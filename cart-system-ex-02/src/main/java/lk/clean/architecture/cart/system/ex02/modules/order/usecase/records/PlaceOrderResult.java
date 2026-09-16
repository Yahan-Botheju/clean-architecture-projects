package lk.clean.architecture.cart.system.ex02.modules.order.usecase.records;

import lk.clean.architecture.cart.system.ex02.modules.order.domain.enums.OrderStatus;
import lk.clean.architecture.cart.system.ex02.modules.order.domain.modules.OrderItem;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record PlaceOrderResult(
        UUID orderId,
        UUID userId,
        double totalAmount,
        OrderStatus orderStatus,
        List<OrderItem> orderItems,
        LocalDateTime createdAt
) {
}
