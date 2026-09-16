package lk.clean.architecture.cart.system.ex02.modules.cart.web.controllers;

import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.AddToCartUseCase;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.GetCartUseCase;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.RemoveFromCartUseCase;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.UpdateCartItemUseCase;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

    //inject required dependencies
    private final AddToCartUseCase addToCartUseCase;
    private final GetCartUseCase getCartUseCase;
    private final UpdateCartItemUseCase updateCartItemUseCase;
    private final RemoveFromCartUseCase removeFromCartUseCase;

    public CartController(
            AddToCartUseCase addToCartUseCase,
            GetCartUseCase getCartUseCase,
            UpdateCartItemUseCase updateCartItemUseCase,
            RemoveFromCartUseCase removeFromCartUseCase
    ) {
        this.addToCartUseCase = addToCartUseCase;
        this.getCartUseCase = getCartUseCase;
        this.updateCartItemUseCase = updateCartItemUseCase;
        this.removeFromCartUseCase = removeFromCartUseCase;
    }
}
