package lk.clean.architecture.smart.cart.order.management.system.modules.cart.infrastructure.configs;

import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.repositories.CartRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.infrastructure.persistence.CartRepositoryImpl;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.infrastructure.persistence.jpa.JpaCartRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.infrastructure.persistence.persistenceMapper.CartPersistenceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceBeanConfigs{

    //cart persistence impl
    @Bean
    public CartRepository cartRepository(
            JpaCartRepository jpaCartRepository,
            CartPersistenceMapper cartPersistenceMapper
    ){
        return new CartRepositoryImpl(jpaCartRepository, cartPersistenceMapper);
    }
}
