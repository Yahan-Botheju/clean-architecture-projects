package lk.clean.architecture.cart.system.ex02.modules.catalog.usecase.api_impl;

import lk.clean.architecture.cart.system.ex02.modules.catalog.api.CatalogStockDeductApi;
import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.repositories.ProductRepository;

public class CatalogStockDeductApiImpl implements CatalogStockDeductApi {

    //inject required dependencies
    private final ProductRepository productRepository;

    public CatalogStockDeductApiImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
