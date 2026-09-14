package lk.clean.architecture.cart.system.ex02.modules.cart.domain.repository;

import lk.clean.architecture.cart.system.ex02.modules.cart.domain.models.Cart;

import java.util.Optional;
import java.util.UUID;

public interface CartRepository {

    //find user by id
    Optional<Cart> findByUserId(UUID userId);

    //save cart
    Cart save(Cart cart);
}
