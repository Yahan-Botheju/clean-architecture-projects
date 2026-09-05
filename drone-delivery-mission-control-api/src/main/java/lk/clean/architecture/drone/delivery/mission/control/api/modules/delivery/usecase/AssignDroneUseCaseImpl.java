package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.enums.DeliveryStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.models.Delivery;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.AssignDroneResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneExistenceCheckApi;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.UUID;

public class AssignDroneUseCaseImpl implements AssignDroneUseCase {

    //inject required dependencies
    private final DeliveryRepository deliveryRepository;
    private final DroneExistenceCheckApi droneExistenceCheckApi;

    public AssignDroneUseCaseImpl(
            DeliveryRepository deliveryRepository,
            DroneExistenceCheckApi droneExistenceCheckApi
    ) {
        this.deliveryRepository = deliveryRepository;
        this.droneExistenceCheckApi = droneExistenceCheckApi;
    }

    //assign a drone
    @Override
    public AssignDroneResult assignDrone(UUID droneId){

        //check delivery existence
        Delivery deliveryExistence = deliveryRepository.getDeliveryById(droneId)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery with id: " + droneId + " not found."));

        //check delivery state is REQUESTED
        if(deliveryExistence.getDeliveryStatus() !=  DeliveryStatus.REQUESTED

        ) {
            throw new IllegalStateException("Delivery status is not proper state to continue the process");
        }

    }
}
