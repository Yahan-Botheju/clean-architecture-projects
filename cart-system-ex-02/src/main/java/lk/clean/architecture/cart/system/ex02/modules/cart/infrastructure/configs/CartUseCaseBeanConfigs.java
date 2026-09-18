package lk.clean.architecture.cart.system.ex02.modules.cart.infrastructure.configs;

import lk.clean.architecture.cart.system.ex02.modules.cart.api.CartQueryApi;
import lk.clean.architecture.cart.system.ex02.modules.cart.domain.repository.CartRepository;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.*;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.api.CartQueryApiImpl;
import lk.clean.architecture.cart.system.ex02.modules.catalog.api.CatalogProductCheckApi;
import lk.clean.architecture.cart.system.ex02.modules.catalog.api.GetProductDetailsApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CartUseCaseBeanConfigs {

    /* __EXTERNAL_API__ */

    @Bean
    public CartQueryApi cartQueryApi(CartRepository cartRepository) {
        return new CartQueryApiImpl(cartRepository);
    }




    /* __DOMAIN_USE CASE__ */


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

    //remove product from cart
    @Bean
    public RemoveFromCartUseCase removeFromCartUseCase(
            CartRepository cartRepository,
            GetProductDetailsApi getProductDetailsApi
    ){
        return new RemoveFromCartUseCaseImpl(cartRepository,getProductDetailsApi);
    }

    //get cart
    @Bean
    public GetCartUseCaseImpl getCartUseCase(
            CartRepository cartRepository
    ){
        return new GetCartUseCaseImpl(cartRepository);
    }
}
