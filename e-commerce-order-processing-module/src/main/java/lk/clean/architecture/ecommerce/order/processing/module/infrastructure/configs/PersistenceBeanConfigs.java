package lk.clean.architecture.ecommerce.order.processing.module.infrastructure.configs;

import lk.clean.architecture.ecommerce.order.processing.module.domain.repositories.OrderRepository;
import lk.clean.architecture.ecommerce.order.processing.module.infrastructure.persistence.order.OrderRepositoryImpl;
import lk.clean.architecture.ecommerce.order.processing.module.infrastructure.persistence.order.jpa.JpaOrderRepository;
import lk.clean.architecture.ecommerce.order.processing.module.infrastructure.persistence.order.persistenceMappers.OrderPersistenceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceBeanConfigs {
    //order repository impl
    @Bean
    public OrderRepository orderRepository(
            JpaOrderRepository jpaOrderRepository,
            OrderPersistenceMapper orderPersistenceMapper
    ){
        return new OrderRepositoryImpl(jpaOrderRepository, orderPersistenceMapper);
    }
}
