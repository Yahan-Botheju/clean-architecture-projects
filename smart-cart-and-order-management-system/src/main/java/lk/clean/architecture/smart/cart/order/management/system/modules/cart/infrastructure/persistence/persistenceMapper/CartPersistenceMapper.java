package lk.clean.architecture.smart.cart.order.management.system.modules.cart.infrastructure.persistence.persistenceMapper;

import lk.clean.architecture.smart.cart.order.management.system.modules.cart.domain.models.Cart;
import lk.clean.architecture.smart.cart.order.management.system.modules.cart.infrastructure.persistence.entities.CartEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartPersistenceMapper {

    //domain model to entity
    CartEntity toEntity(Cart cart);

    //entity to domain model
    Cart toDomainModel(CartEntity cartEntity);
}
