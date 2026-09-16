package lk.clean.architecture.cart.system.ex02.modules.order.infrastructure.persistence;

import lk.clean.architecture.cart.system.ex02.modules.order.domain.modules.Order;
import lk.clean.architecture.cart.system.ex02.modules.order.domain.repository.OrderRepository;
import lk.clean.architecture.cart.system.ex02.modules.order.infrastructure.persistence.entities.OrderEntity;
import lk.clean.architecture.cart.system.ex02.modules.order.infrastructure.persistence.jpa.JpaOrderRepository;
import lk.clean.architecture.cart.system.ex02.modules.order.infrastructure.persistence.persistenceMapper.OrderPersistenceMapper;

import java.util.Optional;
import java.util.UUID;

public class OrderRepositoryImpl implements OrderRepository {

    //inject required dependencies
    private final JpaOrderRepository jpaOrderRepository;
    private final OrderPersistenceMapper orderPersistenceMapper;

    public OrderRepositoryImpl(JpaOrderRepository jpaOrderRepository, OrderPersistenceMapper orderPersistenceMapper) {
        this.jpaOrderRepository = jpaOrderRepository;
        this.orderPersistenceMapper = orderPersistenceMapper;
    }

    //get order by its id
    @Override
    public Optional<Order> getOrderByOrderId(UUID orderId) {
        return jpaOrderRepository.findByOrderId(orderId)
                .map(orderPersistenceMapper::toOrderDomainModel);
    }

    //save order
    @Override
    public Order save(Order order) {

        OrderEntity toOrderEntity = orderPersistenceMapper.toOrderEntity(order);
        OrderEntity savedOrderEntity = jpaOrderRepository.save(toOrderEntity);

        return orderPersistenceMapper.toOrderDomainModel(savedOrderEntity);
    }
}
