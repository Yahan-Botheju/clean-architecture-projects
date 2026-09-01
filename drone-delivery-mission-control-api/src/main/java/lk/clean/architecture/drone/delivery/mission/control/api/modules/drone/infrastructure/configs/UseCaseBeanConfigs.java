package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.infrastructure.configs;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneAssignApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api.DroneAssignApiImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfigs {

    //externally usage api
    @Bean
    public DroneAssignApi droneAssignApi(
            DroneRepository droneRepository
    ) {
        return new DroneAssignApiImpl(droneRepository);
    }
}
