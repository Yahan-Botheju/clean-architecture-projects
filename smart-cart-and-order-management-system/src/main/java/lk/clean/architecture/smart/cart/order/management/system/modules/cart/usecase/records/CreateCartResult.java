package lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.records;

import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.enums.CartStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record CreateCartResult(
        UUID cartId,
        UUID customerId,
        CartStatus cartStatus,
        BigDecimal totalAmount,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
}
