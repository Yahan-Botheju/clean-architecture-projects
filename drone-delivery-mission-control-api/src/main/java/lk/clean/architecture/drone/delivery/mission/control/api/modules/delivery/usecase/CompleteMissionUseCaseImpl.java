package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.enums.DeliveryStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.models.Delivery;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneExistenceCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.enums.DroneStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer.DroneExistenceCheckApiDTO;

import java.util.UUID;

public class CompleteMissionUseCaseImpl implements CompleteMissionUseCase {

    //inject required dependencies
    private final DeliveryRepository deliveryRepository;
    private final DroneExistenceCheckApi droneExistenceCheckApi;

    public CompleteMissionUseCaseImpl(
            DeliveryRepository deliveryRepository,
            DroneExistenceCheckApi droneExistenceCheckApi

    ) {
        this.deliveryRepository = deliveryRepository;
        this.droneExistenceCheckApi = droneExistenceCheckApi;
    }

    //complete mission
    @Override
    public void completeMission(UUID deliveryId) {

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


    }
}
