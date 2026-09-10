package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.models.Delivery;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneExistenceCheckApi;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.UUID;

public class CancelDeliveryUseCaseImpl implements CancelDeliveryUseCase {

    //inject required dependencies
    private final DeliveryRepository deliveryRepository;
    private final DroneExistenceCheckApi  droneExistenceCheckApi;

    public CancelDeliveryUseCaseImpl(
            DeliveryRepository deliveryRepository,
            DroneExistenceCheckApi droneExistenceCheckApi
    ) {
        this.deliveryRepository = deliveryRepository;
        this.droneExistenceCheckApi = droneExistenceCheckApi;
    }

    public void cancelDelivery(UUID deliveryId) {

        Delivery delivery = deliveryRepository.getDeliveryById(deliveryId)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery "+deliveryId+" not found"));

        LocalDateTime currentTime = LocalDateTime.now();
        //call domain cancel logic
        delivery.cancelDelivery(currentTime);

        //check drone is assign to mission

    }
}
