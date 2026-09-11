package lk.clean.architecture.cart.system.ex02.modules.catalog.infrastructure.configs;

import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.repositories.ProductRepository;
import lk.clean.architecture.cart.system.ex02.modules.catalog.infrastructure.persistence.ProductRepositoryImpl;
import lk.clean.architecture.cart.system.ex02.modules.catalog.infrastructure.persistence.jpa.JpaProductRepository;
import lk.clean.architecture.cart.system.ex02.modules.catalog.infrastructure.persistence.persistenceMapper.ProductPersistenceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceBeanConfigs {

    //product persistence bean config
    @Bean
    public ProductRepository productRepository(
            JpaProductRepository jpaProductRepository,
            ProductPersistenceMapper productPersistenceMapper
    ) {
        return new ProductRepositoryImpl(jpaProductRepository, productPersistenceMapper);
    }
}
