package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.persistence.persistenceMappers;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.models.Delivery;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.persistence.entities.DeliveryEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "Spring")
public interface DeliveryPersistenceMapper {

    //domain model to entity
    DeliveryEntity toEntity(Delivery delivery);

    //entity to domain model
    Delivery toDomainModel(DeliveryEntity deliveryEntity);
}
