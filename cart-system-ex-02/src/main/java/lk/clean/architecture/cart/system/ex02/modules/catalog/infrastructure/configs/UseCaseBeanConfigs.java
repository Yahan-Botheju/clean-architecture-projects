package lk.clean.architecture.cart.system.ex02.modules.catalog.infrastructure.configs;

import lk.clean.architecture.cart.system.ex02.modules.catalog.api.CatalogProductCheckApi;
import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.repositories.ProductRepository;
import lk.clean.architecture.cart.system.ex02.modules.catalog.usecase.api_impl.CatalogProductCheckApiImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfigs {

    /* __EXTERNAL_API__ */


    @Bean
    public CatalogProductCheckApi catalogProductCheckApi(
            ProductRepository productRepository
    ) {
        return new CatalogProductCheckApiImpl(productRepository);
    }
}
