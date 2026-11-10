package lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.records;

import java.math.BigDecimal;
import java.util.UUID;

public record ChangeProductPriceCommand(
        UUID productId,
        String productName,
        BigDecimal productPrice
) {
}
