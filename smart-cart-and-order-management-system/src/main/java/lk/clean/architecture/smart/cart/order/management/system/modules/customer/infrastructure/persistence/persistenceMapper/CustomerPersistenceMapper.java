package lk.clean.architecture.smart.cart.order.management.system.modules.customer.infrastructure.persistence.persistenceMapper;

import lk.clean.architecture.smart.cart.order.management.system.modules.customer.domain.models.Customer;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.infrastructure.persistence.entities.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerPersistenceMapper{

    //domain model to entity
    CustomerEntity toEntity(Customer customer);

    //entity to domain model
    Customer toDomainModel(CustomerEntity customerEntity);
}
