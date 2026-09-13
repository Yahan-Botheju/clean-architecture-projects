package lk.clean.architecture.cart.system.ex02.modules.cart.infrastructure.configs;

import lk.clean.architecture.cart.system.ex02.modules.cart.domain.repository.CartRepository;
import lk.clean.architecture.cart.system.ex02.modules.cart.infrastructure.cart.persistence.CartRepositoryImpl;
import lk.clean.architecture.cart.system.ex02.modules.cart.infrastructure.cart.persistence.jpa.JpaCartRepository;
import lk.clean.architecture.cart.system.ex02.modules.cart.infrastructure.cart.persistence.persitenceMapper.CartPersistenceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceBeanConfigs {

    //cart persistence bean impl
    @Bean
    public CartRepository cartRepository(
            JpaCartRepository jpaCartRepository,
            CartPersistenceMapper cartPersistenceMapper
    ){
        return new CartRepositoryImpl(jpaCartRepository,cartPersistenceMapper);
    }
}
