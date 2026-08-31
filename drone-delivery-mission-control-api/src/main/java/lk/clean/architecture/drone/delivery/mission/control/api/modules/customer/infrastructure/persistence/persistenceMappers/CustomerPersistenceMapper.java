package lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.infrastructure.persistence.persistenceMappers;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.domain.models.Customer;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.infrastructure.persistence.entities.CustomerEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerPersistenceMapper {

    //domain model to entity
    CustomerEntity toEntity(Customer customer);

    //entity to domain model
    Customer toDomainModel(CustomerEntity customerEntity);
}
