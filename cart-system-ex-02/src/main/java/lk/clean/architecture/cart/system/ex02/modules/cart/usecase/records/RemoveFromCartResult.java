package lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records;

import java.util.UUID;

public record RemoveFromCartResult(
        UUID productId,
        String productName,
        double unitPrice,
        UUID cartId,
        UUID userId

) {
}
