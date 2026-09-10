package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.models.Delivery;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.enums.FailureReasonStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.FailedMissionCommand;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.FailedMissionResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneExistenceCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneTaskFailApi;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.UUID;

public class FailedMissionUseCaseImpl implements FailedMissionUseCase{

    //inject required dependencies
    private final DeliveryRepository  deliveryRepository;
    private final DroneExistenceCheckApi droneExistenceCheckApi;
    private final DroneTaskFailApi droneTaskFailApi;

    public FailedMissionUseCaseImpl(
            DeliveryRepository deliveryRepository,
            DroneExistenceCheckApi droneExistenceCheckApi,
            DroneTaskFailApi droneTaskFailApi

    ) {
        this.deliveryRepository = deliveryRepository;
        this.droneExistenceCheckApi = droneExistenceCheckApi;
        this.droneTaskFailApi = droneTaskFailApi;
    }

    //failed mission functionality
    @Override
    public FailedMissionResult failedMission(FailedMissionCommand  failedMissionCommand) {

        //check correct failure is initiated state
        if(
                failedMissionCommand.failureReasonStatus() != FailureReasonStatus.BATTERY_CRITICAL
                && failedMissionCommand.failureReasonStatus() != FailureReasonStatus.WEATHER_DETERIORATED
                && failedMissionCommand.failureReasonStatus() != FailureReasonStatus.DRONE_MALFUNCTION
                && failedMissionCommand.failureReasonStatus() != FailureReasonStatus.OTHER
        ){
            throw new IllegalStateException("Failure reason has not been initiated state, try again with correct state");
        }

        Delivery delivery = deliveryRepository.getDeliveryById(failedMissionCommand.deliveryId())
                .orElseThrow(() -> new ResourceNotFoundException("Delivery with id " + failedMissionCommand.deliveryId() + " not found"));

        LocalDateTime currentTime = LocalDateTime.now();
        //call domain model logic
        delivery.deliveryFailedByDrone(currentTime);

        //check drone existence
        droneExistenceCheckApi.checkDroneExistenceById(delivery.getAssignedDroneId());
        //mutate the drone status
        droneTaskFailApi.droneTaskFail(delivery.getAssignedDroneId());


        return  new FailedMissionResult(
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
