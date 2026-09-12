package lk.clean.architecture.cart.system.ex02.modules.catalog.usecase.api_impl;

import lk.clean.architecture.cart.system.ex02.modules.catalog.api.CatalogProductCheckApi;
import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.repositories.ProductRepository;

public class CatalogProductCheckApiImpl implements CatalogProductCheckApi {

    //inject required dependencies
    private final ProductRepository productRepository;

    public CatalogProductCheckApiImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
