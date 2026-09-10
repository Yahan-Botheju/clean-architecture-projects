package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.enums.DeliveryStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.models.Delivery;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.AssignDroneResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneBatteryCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneExistenceCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DronePackageWeightCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.enums.DroneStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.BatteryLevelCheckRainyWeatherApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.CheckFlightSafetyRule1Api;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.CheckFlightSafetyRule2Api;
import lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer.DroneExistenceCheckApiDTO;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.UUID;

public class AssignDroneUseCaseImpl implements AssignDroneUseCase {

    //inject required dependencies
    private final DeliveryRepository deliveryRepository;
    private final DroneExistenceCheckApi droneExistenceCheckApi;
    private final DronePackageWeightCheckApi dronePackageWeightCheckApi;
    private final DroneBatteryCheckApi droneBatteryCheckApi;
    private final BatteryLevelCheckRainyWeatherApi batteryLevelCheckRainyWeatherApi;
    private final CheckFlightSafetyRule1Api checkFlightSafetyRule1Api;
    private final CheckFlightSafetyRule2Api checkFlightSafetyRule2Api;

    public AssignDroneUseCaseImpl(
            DeliveryRepository deliveryRepository,
            DroneExistenceCheckApi droneExistenceCheckApi,
            DronePackageWeightCheckApi dronePackageWeightCheckApi,
            DroneBatteryCheckApi droneBatteryCheckApi,
            BatteryLevelCheckRainyWeatherApi batteryLevelCheckRainyWeatherApi,
            CheckFlightSafetyRule1Api checkFlightSafetyRule1Api,
            CheckFlightSafetyRule2Api checkFlightSafetyRule2Api
    ) {
        this.deliveryRepository = deliveryRepository;
        this.droneExistenceCheckApi = droneExistenceCheckApi;
        this.dronePackageWeightCheckApi = dronePackageWeightCheckApi;
        this.droneBatteryCheckApi = droneBatteryCheckApi;
        this.batteryLevelCheckRainyWeatherApi = batteryLevelCheckRainyWeatherApi;
        this.checkFlightSafetyRule1Api = checkFlightSafetyRule1Api;
        this.checkFlightSafetyRule2Api = checkFlightSafetyRule2Api;
    }

    //assign a drone
    @Override
    public AssignDroneResult assignDrone(UUID droneId){

        //check delivery existence
        Delivery delivery = deliveryRepository.getDeliveryById(droneId)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery with id: " + droneId + " not found."));

        //check delivery state is REQUESTED
        boolean isRequested = delivery.getDeliveryStatus() == DeliveryStatus.REQUESTED;
        if(!isRequested) {
            throw new IllegalStateException("Delivery status is not proper state to continue the process");
        }

        //check drone existence
        DroneExistenceCheckApiDTO drone = droneExistenceCheckApi.checkDroneExistence(droneId);

        //check drone status is AVAILABLE
        boolean isDroneAvailable = drone.droneStatus() == DroneStatus.AVAILABLE;
        if(!isDroneAvailable) {
            throw new IllegalStateException("Drone is not available");
        }

        //check drone payload
        dronePackageWeightCheckApi.checkDronePackageWeight(drone.droneId(), delivery.getPackageWeightKg());

        //check drone battery status
        droneBatteryCheckApi.checkDroneBatteryStatus(drone.droneId(), delivery.getPackageWeightKg());

        /*
        * _OPERATION_DOMAIN_VALIDATIONS
        * */

        checkFlightSafetyRule1Api.checkFlightSafetyRule1(delivery.getPickupLocation(),delivery.getDeliveryLocation());
        checkFlightSafetyRule2Api.checkFlightSafetyRule2(delivery.getPickupLocation(),delivery.getDeliveryLocation());
        batteryLevelCheckRainyWeatherApi.batteryLevelCheckRainyWeather(
                delivery.getPickupLocation(),
                delivery.getDeliveryLocation(),
                drone.batteryPercentage()
        );

        LocalDateTime currentTime = LocalDateTime.now();

        //set delivery to SCHEDULE
        delivery.scheduleDelivery(currentTime);

        //assign a drone
        delivery.assignDelivery(drone.droneId(), currentTime);


        return new AssignDroneResult(
                delivery.getDeliveryId(),
                delivery.getCustomerId(),
                delivery.getAssignedDroneId(),
                delivery.getPackageWeightKg(),
                delivery.getPickupLocation(),
                delivery.getDeliveryLocation(),
                delivery.getDeliveryStatus(),
                delivery.getRequestedAt(),
                delivery.getScheduledAt(),
                delivery.getCompletedAt(),
                delivery.getFailedAt(),
                delivery.getCancelledAt()
        );
    }
}
