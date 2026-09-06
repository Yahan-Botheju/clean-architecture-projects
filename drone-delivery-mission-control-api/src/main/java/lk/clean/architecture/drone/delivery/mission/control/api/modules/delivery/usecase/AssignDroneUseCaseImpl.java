package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.enums.DeliveryStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.models.Delivery;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.AssignDroneResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneBatteryCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneExistenceCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DronePackageWeightCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.enums.DroneStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.BatteryLevelCheckRainyWeather;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.CheckFlightSafetyRule1;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.CheckFlightSafetyRule2;
import lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer.DroneExistenceCheckApiDTO;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.UUID;

public class AssignDroneUseCaseImpl implements AssignDroneUseCase {

    //inject required dependencies
    private final DeliveryRepository deliveryRepository;
    private final DroneExistenceCheckApi droneExistenceCheckApi;
    private final DronePackageWeightCheckApi dronePackageWeightCheckApi;
    private final DroneBatteryCheckApi droneBatteryCheckApi;
    private final BatteryLevelCheckRainyWeather batteryLevelCheckRainyWeather;
    private final CheckFlightSafetyRule1 checkFlightSafetyRule1;
    private final CheckFlightSafetyRule2 checkFlightSafetyRule2;

    public AssignDroneUseCaseImpl(
            DeliveryRepository deliveryRepository,
            DroneExistenceCheckApi droneExistenceCheckApi,
            DronePackageWeightCheckApi dronePackageWeightCheckApi,
            DroneBatteryCheckApi droneBatteryCheckApi,
            BatteryLevelCheckRainyWeather batteryLevelCheckRainyWeather,
            CheckFlightSafetyRule1 checkFlightSafetyRule1,
            CheckFlightSafetyRule2 checkFlightSafetyRule2
    ) {
        this.deliveryRepository = deliveryRepository;
        this.droneExistenceCheckApi = droneExistenceCheckApi;
        this.dronePackageWeightCheckApi = dronePackageWeightCheckApi;
        this.droneBatteryCheckApi = droneBatteryCheckApi;
        this.batteryLevelCheckRainyWeather = batteryLevelCheckRainyWeather;
        this.checkFlightSafetyRule1 = checkFlightSafetyRule1;
        this.checkFlightSafetyRule2 = checkFlightSafetyRule2;
    }

    //assign a drone
    @Override
    public AssignDroneResult assignDrone(UUID droneId){

        //check delivery existence
        Delivery deliveryExistence = deliveryRepository.getDeliveryById(droneId)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery with id: " + droneId + " not found."));

        //check delivery state is REQUESTED
        boolean isRequested = deliveryExistence.getDeliveryStatus() == DeliveryStatus.REQUESTED;
        if(!isRequested) {
            throw new IllegalStateException("Delivery status is not proper state to continue the process");
        }

        //check drone existence
        DroneExistenceCheckApiDTO checkDrone = droneExistenceCheckApi.checkDroneExistence(droneId);

        //check drone status is AVAILABLE
        boolean isDroneAvailable = checkDrone.droneStatus() == DroneStatus.AVAILABLE;
        if(!isDroneAvailable) {
            throw new IllegalStateException("Drone is not available");
        }

        //check drone payload
        dronePackageWeightCheckApi.checkDronePackageWeight(checkDrone.droneId(), deliveryExistence.getPackageWeightKg());

        //check drone battery status
        droneBatteryCheckApi.checkDroneBatteryStatus(checkDrone.droneId(), deliveryExistence.getPackageWeightKg());


    }
}
