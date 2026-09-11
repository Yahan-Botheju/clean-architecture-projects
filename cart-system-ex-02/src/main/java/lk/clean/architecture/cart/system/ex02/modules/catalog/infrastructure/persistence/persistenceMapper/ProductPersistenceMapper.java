package lk.clean.architecture.cart.system.ex02.modules.catalog.infrastructure.persistence.persistenceMapper;

import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.models.Product;
import lk.clean.architecture.cart.system.ex02.modules.catalog.infrastructure.persistence.entities.ProductEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductPersistenceMapper {

    //domain model to entity
    ProductEntity toEntity(Product product);

    //entity to domain model
    Product toDomain(ProductEntity productEntity);
}
