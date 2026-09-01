package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.infrastructure.configs;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.infrastructure.persistence.DroneRepositoryImpl;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.infrastructure.persistence.jpa.JpaDroneRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.infrastructure.persistence.persistenceMappers.DronePersistenceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceBeanConfigs {

    //drone persistence impl
    @Bean
    public DroneRepository  droneRepository(
            JpaDroneRepository jpaDroneRepository,
            DronePersistenceMapper dronePersistenceMapper
    ) {
        return new DroneRepositoryImpl(jpaDroneRepository, dronePersistenceMapper);
    }
}
