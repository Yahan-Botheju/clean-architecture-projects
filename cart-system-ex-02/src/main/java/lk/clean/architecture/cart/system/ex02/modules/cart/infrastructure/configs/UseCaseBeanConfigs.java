package lk.clean.architecture.cart.system.ex02.modules.cart.infrastructure.configs;

import lk.clean.architecture.cart.system.ex02.modules.cart.domain.repository.CartRepository;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.AddToCartUseCase;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.AddToCartUseCaseImpl;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.UpdateCartItemUseCase;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.UpdateCartItemUseCaseImpl;
import lk.clean.architecture.cart.system.ex02.modules.catalog.api.CatalogProductCheckApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfigs {

    //add to cart usecase impl
    @Bean
    public AddToCartUseCase addToCartUseCase(
            CartRepository cartRepository,
            CatalogProductCheckApi catalogProductCheckApi
    ){
        return new AddToCartUseCaseImpl(cartRepository,catalogProductCheckApi);
    }

    //update cart item usecase impl
    @Bean
    public UpdateCartItemUseCase updateCartItemUseCase(
            CartRepository cartRepository,
            CatalogProductCheckApi catalogProductCheckApi
    ){
        return new UpdateCartItemUseCaseImpl(cartRepository,catalogProductCheckApi);
    }
}
