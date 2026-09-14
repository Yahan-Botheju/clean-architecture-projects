package lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records;

import java.util.UUID;

public record UpdateCartItemCommand(
        UUID userId,
        UUID productId,
        int newQuantity
) {
}
