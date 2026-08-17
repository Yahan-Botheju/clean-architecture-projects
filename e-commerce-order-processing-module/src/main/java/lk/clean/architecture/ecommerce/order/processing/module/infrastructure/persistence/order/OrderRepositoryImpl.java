package lk.clean.architecture.ecommerce.order.processing.module.infrastructure.persistence.order;

import lk.clean.architecture.ecommerce.order.processing.module.domain.modules.Order;
import lk.clean.architecture.ecommerce.order.processing.module.domain.repositories.OrderRepository;
import lk.clean.architecture.ecommerce.order.processing.module.infrastructure.persistence.order.entities.OrderEntity;
import lk.clean.architecture.ecommerce.order.processing.module.infrastructure.persistence.order.jpa.JpaOrderRepository;
import lk.clean.architecture.ecommerce.order.processing.module.infrastructure.persistence.order.persistenceMappers.OrderPersistenceMapper;

import java.util.Optional;
import java.util.UUID;

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

    //order find by id
    @Override
    public Optional<Order> findById(UUID orderId) {
        return jpaOrderRepository.findById(orderId).map(orderPersistenceMapper::toDomainModel);
    }

    //save order
    @Override
    public Order save(Order order) {
        OrderEntity orderEntity = orderPersistenceMapper.toEntity(order);
        OrderEntity savedOrderEntity = jpaOrderRepository.save(orderEntity);

        return orderPersistenceMapper.toDomainModel(savedOrderEntity);
    }



}
