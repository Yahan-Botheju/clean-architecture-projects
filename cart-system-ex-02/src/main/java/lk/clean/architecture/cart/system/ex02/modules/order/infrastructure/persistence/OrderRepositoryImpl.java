package lk.clean.architecture.cart.system.ex02.modules.order.infrastructure.persistence;

import lk.clean.architecture.cart.system.ex02.modules.order.domain.repository.OrderRepository;
import lk.clean.architecture.cart.system.ex02.modules.order.infrastructure.persistence.jpa.JpaOrderRepository;
import lk.clean.architecture.cart.system.ex02.modules.order.infrastructure.persistence.persistenceMapper.OrderPersistenceMapper;

public class OrderRepositoryImpl implements OrderRepository {

    //inject required dependencies
    private final JpaOrderRepository jpaOrderRepository;
    private final OrderPersistenceMapper orderPersistenceMapper;

    public OrderRepositoryImpl(JpaOrderRepository jpaOrderRepository, OrderPersistenceMapper orderPersistenceMapper) {
        this.jpaOrderRepository = jpaOrderRepository;
        this.orderPersistenceMapper = orderPersistenceMapper;
    }
}
