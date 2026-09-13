package lk.clean.architecture.cart.system.ex02.modules.cart.infrastructure.cart.persistence.persitenceMapper;

import lk.clean.architecture.cart.system.ex02.modules.cart.domain.models.Cart;
import lk.clean.architecture.cart.system.ex02.modules.cart.infrastructure.cart.persistence.entities.CartEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartPersistenceMapper {

    //domain model to entity
    CartEntity toCartEntity(Cart cart);

    //entity to domain model
    Cart toDomainModel(CartEntity cartEntity);
}
