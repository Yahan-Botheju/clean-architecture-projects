package lk.clean.architecture.smart.cart.order.management.system.modules.product.infrastructure.configs;

import lk.clean.architecture.smart.cart.order.management.system.modules.product.domain.repositories.ProductRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.infrastructure.persistence.ProductRepositoryImpl;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.infrastructure.persistence.jpa.JpaProductRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.infrastructure.persistence.persistenceMapper.ProductPersistenceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceBeanConfigs {

    //product persistence impl
    @Bean
    public ProductRepository productRepository(
            JpaProductRepository jpaProductRepository,
            ProductPersistenceMapper productPersistenceMapper
    ) {
        return new ProductRepositoryImpl(jpaProductRepository, productPersistenceMapper);
    }
}
