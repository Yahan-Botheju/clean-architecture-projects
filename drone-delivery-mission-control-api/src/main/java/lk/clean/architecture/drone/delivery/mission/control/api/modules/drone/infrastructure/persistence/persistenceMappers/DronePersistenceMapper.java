package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.infrastructure.persistence.persistenceMappers;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.models.Drone;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.infrastructure.persistence.entities.DroneEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DronePersistenceMapper {

    //domain model to entity
    DroneEntity toEntity(Drone drone);

    //entity to domain model
    Drone toDomainModel(DroneEntity droneEntity);
}
