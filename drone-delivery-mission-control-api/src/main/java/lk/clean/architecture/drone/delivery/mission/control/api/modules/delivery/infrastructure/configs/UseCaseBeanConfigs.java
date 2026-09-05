package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.configs;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.api.CustomerCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.api.CustomerStatusCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.AssignDroneUseCase;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.AssignDroneUseCaseImpl;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.CreateDeliveryUseCase;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.CreateDeliveryUseCaseImpl;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneExistenceCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DronePackageWeightCheckApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfigs {

    //create delivery usecase impl
    @Bean
    public CreateDeliveryUseCase createDeliveryUseCase(
            DeliveryRepository deliveryRepository,
            CustomerCheckApi customerCheckApi,
            CustomerStatusCheckApi customerStatusCheckApi
    ){
        return new CreateDeliveryUseCaseImpl(deliveryRepository, customerCheckApi, customerStatusCheckApi);
    }

    //assign drone usecase impl
    @Bean
    public AssignDroneUseCase assignDroneUseCase(
            DeliveryRepository deliveryRepository,
            DroneExistenceCheckApi droneExistenceCheckApi,
            DronePackageWeightCheckApi dronePackageWeightCheckApi
    ){
        return new AssignDroneUseCaseImpl(deliveryRepository, droneExistenceCheckApi, dronePackageWeightCheckApi);
    }
}
