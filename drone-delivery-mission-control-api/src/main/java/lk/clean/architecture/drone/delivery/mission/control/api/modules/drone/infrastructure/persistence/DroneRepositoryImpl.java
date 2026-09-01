package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.infrastructure.persistence;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.infrastructure.persistence.jpa.JpaDroneRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.infrastructure.persistence.persistenceMappers.DronePersistenceMapper;

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
}
