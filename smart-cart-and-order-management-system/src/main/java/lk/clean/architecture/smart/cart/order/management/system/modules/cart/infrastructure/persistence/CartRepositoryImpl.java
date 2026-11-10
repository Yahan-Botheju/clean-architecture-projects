package lk.clean.architecture.smart.cart.order.management.system.modules.cart.infrastructure.persistence;

import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.models.Cart;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.repositories.CartRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.infrastructure.persistence.entities.CartEntity;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.infrastructure.persistence.jpa.JpaCartRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.infrastructure.persistence.persistenceMapper.CartPersistenceMapper;

import java.util.Optional;
import java.util.UUID;

public class CartRepositoryImpl implements CartRepository {

    //inject required dependencies
    private final JpaCartRepository jpaCartRepository;
    private final CartPersistenceMapper cartPersistenceMapper;

    public CartRepositoryImpl(JpaCartRepository jpaCartRepository, CartPersistenceMapper cartPersistenceMapper) {
        this.jpaCartRepository = jpaCartRepository;
        this.cartPersistenceMapper = cartPersistenceMapper;
    }

    //find active cart of customer by customerId
    @Override
    public Optional<Cart> getActiveCartByCustomerId(UUID customerId) {
        return jpaCartRepository.findActiveCartByCustomerId(customerId)
                .map(cartPersistenceMapper::toDomainModel);
    }

    //find cart by cartId
    @Override
    public Optional<Cart> getCartByCartId(UUID cartId) {
        return jpaCartRepository.findCartByCartId(cartId)
                .map(cartPersistenceMapper::toDomainModel);
    }

    //save cart
    @Override
    public Cart saveCart(Cart cart) {

        CartEntity toEntity = cartPersistenceMapper.toEntity(cart);
        CartEntity savedCartEntity = jpaCartRepository.save(toEntity);

        return cartPersistenceMapper.toDomainModel(savedCartEntity);
    }
}
