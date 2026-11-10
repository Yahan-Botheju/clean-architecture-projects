package lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.records;

import java.math.BigDecimal;

public record CreateProductCommand(
        String sku,
        String productName,
        String productDescription,
        BigDecimal productPrice
) {
}
