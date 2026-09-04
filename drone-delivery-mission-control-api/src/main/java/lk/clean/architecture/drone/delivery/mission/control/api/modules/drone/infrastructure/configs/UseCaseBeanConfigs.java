package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.infrastructure.configs;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneAssignApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DronePackageWeightCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneTaskCompleteApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneTaskFailApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api.DroneAssignApiImpl;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api.DronePackageWeightCheckApiImpl;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api.DroneTaskCompleteApiImpl;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api.DroneTaskFailApiImpl;
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

    //external usage api
    @Bean
    public DroneTaskCompleteApi droneTaskCompleteApi(
            DroneRepository droneRepository
    ){
        return new DroneTaskCompleteApiImpl(droneRepository);
    }

    //external usage api
    @Bean
    public DroneTaskFailApi droneTaskFailApi(
            DroneRepository droneRepository
    ){
        return new DroneTaskFailApiImpl(droneRepository);
    }

    //external usage api
    @Bean
    public DronePackageWeightCheckApi dronePackageWeightCheckApi(
            DroneRepository droneRepository
    ) {
        return new DronePackageWeightCheckApiImpl(droneRepository);
    }
}
