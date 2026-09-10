package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.models.Delivery;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.enums.FailureReasonStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneTaskFailApi;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.UUID;

public class FailedMissionUseCaseImpl implements FailedMissionUseCase{

    //inject required dependencies
    private final DeliveryRepository  deliveryRepository;
    private final DroneTaskFailApi droneTaskFailApi;

    public FailedMissionUseCaseImpl(
            DeliveryRepository deliveryRepository,
            DroneTaskFailApi droneTaskFailApi

    ) {
        this.deliveryRepository = deliveryRepository;
        this.droneTaskFailApi = droneTaskFailApi;
    }

    public void failedMission(UUID deliveryId, FailureReasonStatus failureReason){

        //check correct failure is initiated state
        if(
                failureReason != FailureReasonStatus.BATTERY_CRITICAL
                && failureReason != FailureReasonStatus.WEATHER_DETERIORATED
                && failureReason != FailureReasonStatus.DRONE_MALFUNCTION
                && failureReason != FailureReasonStatus.OTHER
        ){
            throw new IllegalStateException("Failure reason has not been initiated state, try again with correct state");
        }

        Delivery delivery = deliveryRepository.getDeliveryById(deliveryId)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery with id " + deliveryId + " not found"));

        LocalDateTime currentTime = LocalDateTime.now();
        //call domain model logic
        delivery.deliveryFailedByDrone(currentTime);


    }
}
