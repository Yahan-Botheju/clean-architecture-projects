package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.infrastructure.configs;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.repositories.OrderRepository;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.infrastructure.persistence.OrderRepositoryImpl;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.infrastructure.persistence.jpa.JpaOrderRepository;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.infrastructure.persistence.persistenceMapper.OrderPersistenceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceBeanConfigs {
    //order persistence impl
    @Bean
    public OrderRepository getOrderRepository(
            JpaOrderRepository jpaOrderRepository,
            OrderPersistenceMapper orderPersistenceMapper
    ) {
        return new OrderRepositoryImpl(jpaOrderRepository, orderPersistenceMapper);
    }
}
