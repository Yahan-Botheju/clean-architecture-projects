package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.enums.DeliveryStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.models.Delivery;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneAssignApi;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.UUID;

public class StartMissionUseCaseImpl implements StartMissionUseCase {

    //inject required dependencies
    private final DeliveryRepository deliveryRepository;
    private final DroneAssignApi  droneAssignApi;


    public StartMissionUseCaseImpl(DeliveryRepository deliveryRepository,  DroneAssignApi droneAssignApi) {
        this.deliveryRepository=deliveryRepository;
        this.droneAssignApi=droneAssignApi;
    }

    @Override
    public void startMission(UUID deliveryId) {

        Delivery getDelivery = deliveryRepository.getDeliveryById(deliveryId)
                .orElseThrow(()->new ResourceNotFoundException("Delivery Not Found"));

        //check delivery status == SCHEDULE
        boolean checkDeliveryStatus = getDelivery.getDeliveryStatus() == DeliveryStatus.SCHEDULED;

        if(!checkDeliveryStatus)
            throw new ResourceNotFoundException("cannot process delivery under this status");

        //check assigned drone is available



    }
}
