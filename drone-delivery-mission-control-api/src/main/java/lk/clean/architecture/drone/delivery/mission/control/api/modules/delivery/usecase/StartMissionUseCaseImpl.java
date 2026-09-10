package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.enums.DeliveryStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.models.Delivery;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.StartMissionResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneAssignApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneExistenceCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.enums.DroneStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.CheckFlightSafetyRule1Api;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.CheckFlightSafetyRule2Api;
import lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer.DroneExistenceCheckApiDTO;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.UUID;

public class StartMissionUseCaseImpl implements StartMissionUseCase {

    //inject required dependencies
    private final DeliveryRepository deliveryRepository;
    private final DroneAssignApi  droneAssignApi;
    private final DroneExistenceCheckApi  droneExistenceCheckApi;
    private final CheckFlightSafetyRule1Api  checkFlightSafetyRule1Api;
    private final CheckFlightSafetyRule2Api checkFlightSafetyRule2Api;


    public StartMissionUseCaseImpl(
            DeliveryRepository deliveryRepository,
            DroneAssignApi droneAssignApi,
            DroneExistenceCheckApi droneExistenceCheckApi,
            CheckFlightSafetyRule1Api checkFlightSafetyRule1Api,
            CheckFlightSafetyRule2Api checkFlightSafetyRule2Api
    ) {
        this.deliveryRepository=deliveryRepository;
        this.droneAssignApi=droneAssignApi;
        this.droneExistenceCheckApi=droneExistenceCheckApi;
        this.checkFlightSafetyRule1Api=checkFlightSafetyRule1Api;
        this.checkFlightSafetyRule2Api=checkFlightSafetyRule2Api;
    }

    //delivery starts
    @Override
    public StartMissionResult startMission(UUID deliveryId) {

        Delivery getDelivery = deliveryRepository.getDeliveryById(deliveryId)
                .orElseThrow(()->new ResourceNotFoundException("Delivery Not Found"));

        //check delivery status == SCHEDULE
        boolean checkDeliveryStatus = getDelivery.getDeliveryStatus() == DeliveryStatus.SCHEDULED;

        if(!checkDeliveryStatus)
            throw new ResourceNotFoundException("cannot process delivery under this status");

        //check assigned drone is available
        boolean isDroneAssigned = droneExistenceCheckApi.checkDroneExistenceById(getDelivery.getAssignedDroneId());

        if(!isDroneAssigned){
            throw new ResourceNotFoundException("cannot process drone under this status");
        }

        DroneExistenceCheckApiDTO getDroneStaus = droneExistenceCheckApi.checkDroneExistence(getDelivery.getAssignedDroneId());

        //check drone status is AVAILABLE
        boolean isDroneAvailable = getDroneStaus.droneStatus() == DroneStatus.AVAILABLE;

        if(!isDroneAvailable){
            throw new IllegalStateException("cannot process drone under this status");
        }

        //check weather condition again
        checkFlightSafetyRule1Api.checkFlightSafetyRule1(getDelivery.getPickupLocation(), getDelivery.getDeliveryLocation());
        checkFlightSafetyRule2Api.checkFlightSafetyRule2(getDelivery.getPickupLocation(), getDelivery.getDeliveryLocation());

        /*
        * call domain logic for state mutate
        * */

        LocalDateTime startTime = LocalDateTime.now();
        getDelivery.inProgressDelivery(startTime);
        //assign drone for mission (ON_MISSION)
        droneAssignApi.droneAssignForMission(getDelivery.getAssignedDroneId());

        deliveryRepository.save(getDelivery);

        return new StartMissionResult(
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
