package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.enums.DeliveryStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.models.Delivery;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CompleteMissionResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneBatteryConsumptionCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneExistenceCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneTaskCompleteApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.enums.DroneStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer.DroneExistenceCheckApiDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public class CompleteMissionUseCaseImpl implements CompleteMissionUseCase {

    //inject required dependencies
    private final DeliveryRepository deliveryRepository;
    private final DroneExistenceCheckApi droneExistenceCheckApi;
    private final DroneBatteryConsumptionCheckApi droneBatteryConsumptionCheckApi;
    private final DroneTaskCompleteApi droneTaskCompleteApi;

    public CompleteMissionUseCaseImpl(
            DeliveryRepository deliveryRepository,
            DroneExistenceCheckApi droneExistenceCheckApi,
            DroneBatteryConsumptionCheckApi droneBatteryConsumptionCheckApi,
            DroneTaskCompleteApi droneTaskCompleteApi

    ) {
        this.deliveryRepository = deliveryRepository;
        this.droneExistenceCheckApi = droneExistenceCheckApi;
        this.droneBatteryConsumptionCheckApi = droneBatteryConsumptionCheckApi;
        this.droneTaskCompleteApi = droneTaskCompleteApi;
    }

    //complete mission
    @Override
    public CompleteMissionResult completeMission(UUID deliveryId) {

        Delivery getDelivery = deliveryRepository.getDeliveryById(deliveryId)
                .orElseThrow(() -> new RuntimeException("delivery not found"));

        //check delivery status IN_PROGRESS
        boolean isDeliveryInProgress = getDelivery.getDeliveryStatus() == DeliveryStatus.IN_PROGRESS;

        if(!isDeliveryInProgress){
            throw new IllegalStateException("delivery is not in progress");
        }

        //check drone status ON_MISSION
        DroneExistenceCheckApiDTO getDrone = droneExistenceCheckApi.checkDroneExistence(getDelivery.getAssignedDroneId());

        boolean isDroneOnMission = getDrone.droneStatus() == DroneStatus.ON_MISSION;

        if(!isDroneOnMission){
            throw new IllegalStateException("drone is not required progress to continue the mission");
        }

        //mutate drone battery consumption
        droneBatteryConsumptionCheckApi.droneBatteryConsumptionCheckApi(getDrone.droneId(), getDelivery.getPackageWeightKg());

        LocalDateTime currentTime = LocalDateTime.now();

        //mutate delivery status to DELIVERED
        getDelivery.deliveredByDrone(currentTime);

        //set dron status to AVAILABLE
        droneTaskCompleteApi.droneTaskComplete(getDrone.droneId());

        //save delivery
        deliveryRepository.save(getDelivery);

        return new CompleteMissionResult(
                getDelivery.getDeliveryId(),
                getDelivery.getCustomerId(),
                getDelivery.getAssignedDroneId(),
                getDelivery.getPackageWeightKg(),
                getDelivery.getPickupLocation(),
                getDelivery.getDeliveryLocation(),
                getDelivery.getDeliveryStatus(),
                getDelivery.getRequestedAt(),
                getDelivery.getScheduledAt(),
                getDelivery.getStartedAt(),
                getDelivery.getCompletedAt(),
                getDelivery.getFailedAt(),
                getDelivery.getCancelledAt()
        );
    }
}
