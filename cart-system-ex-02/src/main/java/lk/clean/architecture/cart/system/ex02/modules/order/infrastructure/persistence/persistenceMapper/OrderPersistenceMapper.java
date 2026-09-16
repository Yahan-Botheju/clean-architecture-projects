package lk.clean.architecture.cart.system.ex02.modules.order.infrastructure.persistence.persistenceMapper;

import lk.clean.architecture.cart.system.ex02.modules.order.domain.modules.Order;
import lk.clean.architecture.cart.system.ex02.modules.order.infrastructure.persistence.entities.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderPersistenceMapper {

    //domain model to entity
    OrderEntity toOrderEntity(Order order);

    //entity to domain model
    Order toOrderDomainModel(OrderEntity orderEntity);
}
