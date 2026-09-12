package lk.clean.architecture.cart.system.ex02.modules.catalog.usecase;

import lk.clean.architecture.cart.system.ex02.modules.catalog.usecase.records.CreateProductCommand;
import lk.clean.architecture.cart.system.ex02.modules.catalog.usecase.records.CreateProductResult;

public interface CreateProductUseCase{

    //create product
    CreateProductResult execute(CreateProductCommand createProductCommand);
}
