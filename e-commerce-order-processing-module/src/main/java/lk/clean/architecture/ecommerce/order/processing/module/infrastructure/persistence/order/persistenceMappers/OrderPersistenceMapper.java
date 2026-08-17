package lk.clean.architecture.ecommerce.order.processing.module.infrastructure.persistence.order.persistenceMappers;

import lk.clean.architecture.ecommerce.order.processing.module.domain.modules.Order;
import lk.clean.architecture.ecommerce.order.processing.module.infrastructure.persistence.order.entities.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderPersistenceMapper {
    //domain model to entity
    OrderEntity toEntity(Order order);

    //entity to domain model
    Order toDomainModel(OrderEntity orderEntity);
}
