package lk.clean.architecture.cart.system.ex02.modules.catalog.infrastructure.persistence;

import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.repositories.ProductRepository;
import lk.clean.architecture.cart.system.ex02.modules.catalog.infrastructure.persistence.jpa.JpaProductRepository;
import lk.clean.architecture.cart.system.ex02.modules.catalog.infrastructure.persistence.persistenceMapper.ProductPersistenceMapper;

public class ProductRepositoryImpl implements ProductRepository {

    //inject required dependencies
    private final JpaProductRepository jpaProductRepository;
    private final ProductPersistenceMapper productPersistenceMapper;

    public ProductRepositoryImpl(
            JpaProductRepository jpaProductRepository,
            ProductPersistenceMapper productPersistenceMapper
    ) {
        this.jpaProductRepository = jpaProductRepository;
        this.productPersistenceMapper = productPersistenceMapper;
    }
}
