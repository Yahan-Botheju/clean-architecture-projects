package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.infrastructure.persistence;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.repositories.OrderRepository;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.infrastructure.persistence.jpa.JpaOrderRepository;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.infrastructure.persistence.persistenceMapper.OrderPersistenceMapper;

public class OrderRepositoryImpl implements OrderRepository {

    //inject required dependencies
    private final JpaOrderRepository jpaOrderRepository;
    private final OrderPersistenceMapper orderPersistenceMapper;

    public OrderRepositoryImpl(
            JpaOrderRepository jpaOrderRepository,
            OrderPersistenceMapper orderPersistenceMapper
    ) {
        this.jpaOrderRepository = jpaOrderRepository;
        this.orderPersistenceMapper = orderPersistenceMapper;
    }
}
