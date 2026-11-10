package lk.clean.architecture.smart.cart.order.management.system.shared_domain.product_shared_api;

import lk.clean.architecture.smart.cart.order.management.system.modules.product.domain.enums.ProductStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record ActiveProductCheckApiResult(
        UUID productId,
        String sku,
        String productName,
        String productDescription,
        BigDecimal productPrice,
        ProductStatus productStatus,
        LocalDateTime createdAt
) {
}
