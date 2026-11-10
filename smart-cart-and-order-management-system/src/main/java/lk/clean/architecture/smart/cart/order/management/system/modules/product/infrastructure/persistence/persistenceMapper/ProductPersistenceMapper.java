package lk.clean.architecture.smart.cart.order.management.system.modules.product.infrastructure.persistence.persistenceMapper;

import lk.clean.architecture.smart.cart.order.management.system.modules.product.domain.models.Product;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.infrastructure.persistence.entities.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductPersistenceMapper {

    //domain model to entity
    ProductEntity toEntity(Product product);

    //entity to domain model
    Product toDomainModel(ProductEntity productEntity);
}
