package lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.repositories;

import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.models.Cart;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository {

    //find active cart by customer id
    Optional<Cart> getActiveCartByCustomerId(UUID customerId);

    //find a cart by id
    Optional<Cart> getCartByCartId(UUID cartId);

    //save cart
    Cart saveCart(Cart cart);
}
