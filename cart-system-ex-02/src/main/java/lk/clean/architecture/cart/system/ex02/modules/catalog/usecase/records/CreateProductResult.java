package lk.clean.architecture.cart.system.ex02.modules.catalog.usecase.records;

import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.enums.ProductStatus;

import java.util.UUID;

public record CreateProductResult(
         UUID productId,
         String productName,
         double unitPrice,
         int stockQuantity,
         ProductStatus productStatus
) {
}
