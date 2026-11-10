package lk.clean.architecture.smart.cart.order.management.system.modules.product.infrastructure.configs;

import lk.clean.architecture.smart.cart.order.management.system.modules.product.api.ActiveProductCheckApi;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.domain.repositories.ProductRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.ChangeProductPriceUseCase;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.ChangeProductPriceUseCaseImpl;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.CreateProductUseCase;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.CreateProductUseCaseImpl;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.api.ActiveProductCheckApiImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfigs {

    //create product usecase impl
    @Bean
    public CreateProductUseCase createProductUseCase(
            ProductRepository productRepository
    ) {
        return new CreateProductUseCaseImpl(productRepository);
    }

    //change product price usecase impl
    @Bean
    public ChangeProductPriceUseCase changeProductPriceUseCase(
            ProductRepository productRepository
    ){
        return new ChangeProductPriceUseCaseImpl(productRepository);
    }

    /* __EXTERNAL_API__ */


    //check active product
    @Bean
    public ActiveProductCheckApi activeProductCheckApi(ProductRepository productRepository) {
        return new ActiveProductCheckApiImpl(productRepository);
    }
}
