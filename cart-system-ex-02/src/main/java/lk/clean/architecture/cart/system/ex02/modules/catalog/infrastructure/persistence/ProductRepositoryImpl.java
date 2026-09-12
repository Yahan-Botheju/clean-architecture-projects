package lk.clean.architecture.cart.system.ex02.modules.catalog.infrastructure.persistence;

import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.models.Product;
import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.repositories.ProductRepository;
import lk.clean.architecture.cart.system.ex02.modules.catalog.infrastructure.persistence.entities.ProductEntity;
import lk.clean.architecture.cart.system.ex02.modules.catalog.infrastructure.persistence.jpa.JpaProductRepository;
import lk.clean.architecture.cart.system.ex02.modules.catalog.infrastructure.persistence.persistenceMapper.ProductPersistenceMapper;

import java.util.Optional;
import java.util.UUID;

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

    //check product existence
    @Override
    public boolean existsById(UUID productId) {
        return jpaProductRepository.existsByProductId(productId);
    }

    //product find by its id
    @Override
    public Optional<Product> productFindById(UUID productId) {
        return jpaProductRepository.findByProductId(productId)
                .map(productPersistenceMapper::toDomain);
    }

    //save product
    @Override
    public Product saveProduct(Product product) {

        ProductEntity toEntity = productPersistenceMapper.toEntity(product);
        ProductEntity savedEntity = jpaProductRepository.save(toEntity);

        return productPersistenceMapper.toDomain(savedEntity);
    }
}
