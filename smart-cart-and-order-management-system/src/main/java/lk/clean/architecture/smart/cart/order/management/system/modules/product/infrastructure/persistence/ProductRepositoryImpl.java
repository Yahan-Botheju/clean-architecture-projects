package lk.clean.architecture.smart.cart.order.management.system.modules.product.infrastructure.persistence;

import lk.clean.architecture.smart.cart.order.management.system.modules.product.domain.models.Product;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.domain.repositories.ProductRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.infrastructure.persistence.entities.ProductEntity;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.infrastructure.persistence.jpa.JpaProductRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.infrastructure.persistence.persistenceMapper.ProductPersistenceMapper;

import java.util.Optional;
import java.util.UUID;

public class ProductRepositoryImpl implements ProductRepository {

    //inject required dependencies
    private final JpaProductRepository jpaProductRepository;
    private final ProductPersistenceMapper productPersistenceMapper;

    public ProductRepositoryImpl(JpaProductRepository jpaProductRepository, ProductPersistenceMapper productPersistenceMapper) {
        this.jpaProductRepository = jpaProductRepository;
        this.productPersistenceMapper = productPersistenceMapper;
    }

    //check existence by sku
    @Override
    public boolean checkProductBySku(String sku) {
        return jpaProductRepository.findBySku(sku);
    }

    //find product by id
    @Override
    public Optional<Product> getProductById(UUID productId) {
        return jpaProductRepository.findById(productId).map(productPersistenceMapper::toDomainModel);
    }

    //save product
    @Override
    public Product saveProduct(Product product) {

        ProductEntity  productEntity = productPersistenceMapper.toEntity(product);
        ProductEntity savedEntity = jpaProductRepository.save(productEntity);

        return productPersistenceMapper.toDomainModel(savedEntity);
    }


}
