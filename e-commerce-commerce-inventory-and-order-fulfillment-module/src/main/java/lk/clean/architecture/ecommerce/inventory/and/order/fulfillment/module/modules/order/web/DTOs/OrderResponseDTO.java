package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.web.DTOs;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record OrderResponseDTO(
        UUID orderId,
        UUID customerId,
        UUID productId,
        int quantity,
        BigDecimal totalPrice,
        OrderStatus orderStatus,
        LocalDateTime createdAt
) {}
