package lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.removeItem_cart;

import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.models.Cart;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.repositories.CartRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.usecase.records.RemoveCartItemResult;

import java.time.LocalDateTime;
import java.util.UUID;

public class RemoveCartItemUseCaseImpl implements RemoveCartItemUseCase {

    //inject required dependencies
    private final CartRepository cartRepository;

    public RemoveCartItemUseCaseImpl(
            CartRepository cartRepository
    ) {
        this.cartRepository = cartRepository;
    }

    //remove item from cart
    @Override
    public RemoveCartItemResult removeCartItem(UUID cartId, UUID cartItemId, UUID productId) {
        //check inputs are empty
        if(cartId == null || cartItemId == null || productId == null) {
            throw new IllegalStateException("Fields cannot be empty");
        }
        //check cart existence
        Cart getCart = cartRepository.getCartByCartId(cartId)
                .orElseThrow(() -> new IllegalStateException("cart not found"));

        LocalDateTime currentTime = LocalDateTime.now();

        //call domain remove method for remove product
        getCart.removeItem(cartItemId, productId, currentTime);

        cartRepository.saveCart(getCart);

        return new RemoveCartItemResult(
               getCart.getCartId(),
               cartItemId,
               getCart.getCustomerId(),
               productId,
               getCart.getCartStatus(),
               getCart.getTotalAmount(),
               getCart.getCreatedAt(),
               getCart.getUpdatedAt(),
               getCart.getCartItems()
        );
    }
}
