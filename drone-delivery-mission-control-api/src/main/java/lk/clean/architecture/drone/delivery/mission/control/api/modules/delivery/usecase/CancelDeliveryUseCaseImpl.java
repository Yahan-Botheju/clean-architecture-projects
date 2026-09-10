package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.models.Delivery;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.UUID;

public class CancelDeliveryUseCaseImpl implements CancelDeliveryUseCase {

    //inject required dependencies
    private final DeliveryRepository deliveryRepository;

    public CancelDeliveryUseCaseImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public void cancelDelivery(UUID deliveryId) {

        Delivery delivery = deliveryRepository.getDeliveryById(deliveryId)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery "+deliveryId+" not found"));

        LocalDateTime currentTime = LocalDateTime.now();
        //call domain cancel logic
        delivery.cancelDelivery(currentTime);
    }
}
