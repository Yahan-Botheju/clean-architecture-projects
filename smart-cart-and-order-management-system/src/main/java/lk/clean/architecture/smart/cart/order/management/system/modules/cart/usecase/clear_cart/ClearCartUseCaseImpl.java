package lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.clear_cart;

import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.models.Cart;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.repositories.CartRepository;

import java.util.UUID;

public class ClearCartUseCaseImpl implements  ClearCartUseCase {

    //inject required dependencies
    private final CartRepository cartRepository;

    public ClearCartUseCaseImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    //clear cart
    @Override
    public void clearCart(UUID cartId){
        //check cart existence
        Cart cart = cartRepository.getCartByCartId(cartId)
                .orElseThrow(() -> new IllegalStateException("cart not found"));

        //clear cart
        cart.clearCart();

        cartRepository.saveCart(cart);
    }
}
