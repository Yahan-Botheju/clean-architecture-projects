package lk.clean.architecture.cart.system.ex02.modules.catalog.usecase.records;

public record CreateProductCommand(
        String productName,
        double unitPrice,
        int initialStock
) {
}
