package lk.clean.architecture.ecommerce.order.processing.module.web.DTOs;

import lk.clean.architecture.ecommerce.order.processing.module.domain.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record OrderResponseDTO(
        UUID orderId,
        UUID customerId,
        BigDecimal totalAmount,
        OrderStatus status,
        String shippingAddress,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
