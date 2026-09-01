package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.infrastructure.persistence;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.models.Drone;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.infrastructure.persistence.entities.DroneEntity;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.infrastructure.persistence.jpa.JpaDroneRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.infrastructure.persistence.persistenceMappers.DronePersistenceMapper;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.Optional;
import java.util.UUID;

public class DroneRepositoryImpl implements DroneRepository {

    //inject required dependencies
    private final JpaDroneRepository jpaDroneRepository;
    private final DronePersistenceMapper dronePersistenceMapper;

    public DroneRepositoryImpl(
            JpaDroneRepository jpaDroneRepository,
            DronePersistenceMapper dronePersistenceMapper
    ) {
        this.jpaDroneRepository = jpaDroneRepository;
        this.dronePersistenceMapper = dronePersistenceMapper;
    }


    //drone find by id
    @Override
    public Optional<Drone> droneFindById(UUID uuid){
        return jpaDroneRepository.findById(uuid)
                .map(dronePersistenceMapper::toDomainModel);
    }
}
