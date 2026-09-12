package lk.clean.architecture.cart.system.ex02.modules.shared_domain.catalog.api_records;

import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.enums.ProductStatus;

import java.util.UUID;

public record CatalogProductCheckResult(
         UUID productId,
         String productName,
         double unitPrice,
         int stockQuantity,
         ProductStatus productStatus
) {
}
