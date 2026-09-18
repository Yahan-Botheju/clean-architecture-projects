package lk.clean.architecture.cart.system.ex02.modules.order.infrastructure.configs;

import lk.clean.architecture.cart.system.ex02.modules.order.domain.repository.OrderRepository;
import lk.clean.architecture.cart.system.ex02.modules.order.infrastructure.persistence.OrderRepositoryImpl;
import lk.clean.architecture.cart.system.ex02.modules.order.infrastructure.persistence.jpa.JpaOrderRepository;
import lk.clean.architecture.cart.system.ex02.modules.order.infrastructure.persistence.persistenceMapper.OrderPersistenceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderPersistenceBeanConfigs {

    //order persistence impl
    @Bean
    public OrderRepository orderRepository(
            JpaOrderRepository jpaOrderRepository,
            OrderPersistenceMapper orderPersistenceMapper
    ) {
        return new OrderRepositoryImpl(jpaOrderRepository, orderPersistenceMapper);
    }
}
