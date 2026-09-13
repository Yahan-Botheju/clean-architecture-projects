package lk.clean.architecture.cart.system.ex02.modules.cart.infrastructure.cart.persistence;

import lk.clean.architecture.cart.system.ex02.modules.cart.domain.repository.CartRepository;
import lk.clean.architecture.cart.system.ex02.modules.cart.infrastructure.cart.persistence.jpa.JpaCartRepository;
import lk.clean.architecture.cart.system.ex02.modules.cart.infrastructure.cart.persistence.persitenceMapper.CartPersistenceMapper;

public class CartRepositoryImpl implements CartRepository {

    //inject required dependencies
    private final JpaCartRepository jpaCartRepository;
    private final CartPersistenceMapper cartPersistenceMapper;

    public CartRepositoryImpl(
            JpaCartRepository jpaCartRepository,
            CartPersistenceMapper cartPersistenceMapper
    ) {
        this.jpaCartRepository = jpaCartRepository;
        this.cartPersistenceMapper = cartPersistenceMapper;
    }
}
