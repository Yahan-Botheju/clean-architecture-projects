package lk.clean.architecture.smart.cart.order.management.system.modules.cart.infrastructure.configs;

import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.repositories.CartRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.clear_cart.ClearCartUseCase;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.clear_cart.ClearCartUseCaseImpl;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.addItem_cart.AddItemToCartUseCase;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.addItem_cart.AddItemToCartUseCaseImpl;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.changeItemQuantity_cart.ChangeCartItemQuantityUseCase;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.changeItemQuantity_cart.ChangeCartItemQuantityUseCaseImpl;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.create_cart.CreateCartUseCase;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.create_cart.CreateCartUseCaseImpl;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.removeItem_cart.RemoveCartItemUseCase;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.removeItem_cart.RemoveCartItemUseCaseImpl;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.api.CheckCustomerApi;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.api.ActiveProductCheckApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfigs {

    //clear cart usecase impl
    @Bean
    public ClearCartUseCase clearCartUseCase(
            CartRepository cartRepository
    ) {
        return new ClearCartUseCaseImpl(cartRepository);
    }

    //create cart usecase impl
    @Bean
    public CreateCartUseCase createCartUseCase(
            CartRepository cartRepository,
            CheckCustomerApi checkCustomerApi
    ){
        return new CreateCartUseCaseImpl(cartRepository, checkCustomerApi);
    }

    //add item to cart
    @Bean
    public AddItemToCartUseCase addItemToCartUseCase(
            CartRepository cartRepository,
            ActiveProductCheckApi  activeProductCheckApi
    ){
        return new AddItemToCartUseCaseImpl(cartRepository, activeProductCheckApi);
    }

    //change cart item quantity usecase impl
    @Bean
    public ChangeCartItemQuantityUseCase changeCartItemQuantityUseCase(
            CartRepository cartRepository
    ){
        return new ChangeCartItemQuantityUseCaseImpl(cartRepository);
    }

    //remove items from cart usecase impl
    @Bean
    public RemoveCartItemUseCase removeCartItemUseCase(
            CartRepository cartRepository
    ){
        return new RemoveCartItemUseCaseImpl(cartRepository);
    }

}
