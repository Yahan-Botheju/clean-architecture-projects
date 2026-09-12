package lk.clean.architecture.cart.system.ex02.modules.catalog.usecase;

import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.repositories.ProductRepository;

public class CreateProductUseCaseImpl implements CreateProductUseCase{

    //inject required dependencies
    private final ProductRepository productRepository;

    public CreateProductUseCaseImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
