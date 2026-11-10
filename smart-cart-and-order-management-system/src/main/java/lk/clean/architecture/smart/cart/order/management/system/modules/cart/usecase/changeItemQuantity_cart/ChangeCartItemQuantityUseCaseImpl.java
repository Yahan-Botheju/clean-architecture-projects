package lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.changeItemQuantity_cart;

import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.models.Cart;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.repositories.CartRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.records.ChangeCartItemQuantityResult;

import java.time.LocalDateTime;
import java.util.UUID;

public class ChangeCartItemQuantityUseCaseImpl implements ChangeCartItemQuantityUseCase {

    //inject required dependencies
    private final CartRepository cartRepository;

    public ChangeCartItemQuantityUseCaseImpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    //change cart item quantity
    @Override
    public ChangeCartItemQuantityResult changeCartItemQuantity(UUID cartId, UUID cartItemId, int newQuantity) {
        //check inputs are empty
        if(cartId == null || cartItemId == null || newQuantity <= 0) {
            throw new IllegalArgumentException("cartId and cartItemId must not be null");
        }

        //get cart
        Cart getCart = cartRepository.getCartByCartId(cartId)
                .orElseThrow(() -> new IllegalStateException("cart not found"));

        LocalDateTime currentTime = LocalDateTime.now();

        //call domain logic change item quantity method
        getCart.changeItemQuantity(
                getCart.getCartId(),
                cartItemId,
                newQuantity,
                currentTime
        );

        cartRepository.saveCart(getCart);

        return new ChangeCartItemQuantityResult(
                getCart.getCartId(),
                getCart.getCustomerId(),
                getCart.getCartStatus(),
                getCart.getTotalAmount(),
                getCart.getCreatedAt(),
                getCart.getUpdatedAt(),
                getCart.getCartItems()
        );
    }
}
