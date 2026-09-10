package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.configs;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.api.CustomerCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.api.CustomerStatusCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.*;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.*;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.BatteryLevelCheckRainyWeatherApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.CheckFlightSafetyRule1Api;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.CheckFlightSafetyRule2Api;
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
            DronePackageWeightCheckApi dronePackageWeightCheckApi,
            DroneBatteryCheckApi droneBatteryCheckApi,
            BatteryLevelCheckRainyWeatherApi batteryLevelCheckRainyWeatherApi,
            CheckFlightSafetyRule1Api checkFlightSafetyRule1Api,
            CheckFlightSafetyRule2Api checkFlightSafetyRule2Api
    ){
        return new AssignDroneUseCaseImpl(
                deliveryRepository,
                droneExistenceCheckApi,
                dronePackageWeightCheckApi,
                droneBatteryCheckApi,
                batteryLevelCheckRainyWeatherApi,
                checkFlightSafetyRule1Api,
                checkFlightSafetyRule2Api
        );
    }

    //mission start usecase impl
    @Bean
    public StartMissionUseCase startMissionUseCase(
            DeliveryRepository deliveryRepository,
            DroneAssignApi droneAssignApi,
            DroneExistenceCheckApi droneExistenceCheckApi,
            CheckFlightSafetyRule1Api checkFlightSafetyRule1Api,
            CheckFlightSafetyRule2Api checkFlightSafetyRule2Api
    ){
        return new StartMissionUseCaseImpl(
                deliveryRepository,
                droneAssignApi,
                droneExistenceCheckApi,
                checkFlightSafetyRule1Api,
                checkFlightSafetyRule2Api
        );
    }

    //complete mission usecase impl
    @Bean
    public CompleteMissionUseCase completeMissionUseCase(
            DeliveryRepository deliveryRepository,
            DroneExistenceCheckApi droneExistenceCheckApi,
            DroneBatteryConsumptionCheckApi droneBatteryConsumptionCheckApi,
            DroneTaskCompleteApi droneTaskCompleteApi
    ){
        return new CompleteMissionUseCaseImpl(
                deliveryRepository,
                droneExistenceCheckApi,
                droneBatteryConsumptionCheckApi,
                droneTaskCompleteApi

        );
    }

    //failed mission usecase impl
    @Bean
    public FailedMissionUseCase failedMissionUseCase(
            DeliveryRepository deliveryRepository,
            DroneExistenceCheckApi droneExistenceCheckApi,
            DroneTaskFailApi droneTaskFailApi
    ){
        return new FailedMissionUseCaseImpl(deliveryRepository, droneExistenceCheckApi, droneTaskFailApi);
    }

    //cancel delivery usecase impl
    @Bean
    public CancelDeliveryUseCase cancelDeliveryUseCase(
            DeliveryRepository deliveryRepository,
            DroneExistenceCheckApi droneExistenceCheckApi
    ){
        return new CancelDeliveryUseCaseImpl(deliveryRepository, droneExistenceCheckApi);
    }
}
