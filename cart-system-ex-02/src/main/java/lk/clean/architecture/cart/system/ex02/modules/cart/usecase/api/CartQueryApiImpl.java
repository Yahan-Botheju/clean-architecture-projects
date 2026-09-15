package lk.clean.architecture.cart.system.ex02.modules.cart.usecase.api;

import lk.clean.architecture.cart.system.ex02.modules.cart.api.CartQueryApi;
import lk.clean.architecture.cart.system.ex02.modules.cart.domain.models.Cart;
import lk.clean.architecture.cart.system.ex02.modules.cart.domain.repository.CartRepository;
import lk.clean.architecture.cart.system.ex02.modules.shared_domain.catalog.api_records.CartDetailsResult;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.UUID;

public class CartQueryApiImpl implements CartQueryApi {

    //inject required dependencies
    private final CartRepository cartRepository;

    public CartQueryApiImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    //cart details
    @Override
    public CartDetailsResult getCartByUserId(UUID userId) {

        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));

        return new CartDetailsResult(
                cart.getCartId(),
                cart.getUserId(),
                cart.getCartItems(),
                cart.getTotalPrice()
        );
    }

    //clear cart
    @Override
    public void clearCartByUserId(UUID userId) {
        //get cart
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Cart not found"));

        //clear cart using domai model method
        cart.clearCart();
    }
}
