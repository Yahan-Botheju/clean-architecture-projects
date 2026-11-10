package lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.records;

import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.enums.CartStatus;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.models.CartItem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record RemoveCartItemResult(
        UUID cartId,
        UUID cartItemId,
        UUID customerId,
        UUID productId,
        CartStatus cartStatus,
        BigDecimal totalAmount,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        List<CartItem> cartItems
) {
}
