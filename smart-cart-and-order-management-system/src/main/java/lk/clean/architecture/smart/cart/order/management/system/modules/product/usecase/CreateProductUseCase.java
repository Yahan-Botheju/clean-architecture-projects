package lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase;

import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.records.CreateProductCommand;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.records.CreateProductResult;

public interface CreateProductUseCase {

    //create new product
    CreateProductResult createProduct(CreateProductCommand createProductCommand);
}
