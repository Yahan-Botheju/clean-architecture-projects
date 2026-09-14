package lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records;

import java.util.UUID;

public record UpdateCartItemResult(
        UUID productId,
        String productName,
        double unitPrice,
        int quantity
) {
}
