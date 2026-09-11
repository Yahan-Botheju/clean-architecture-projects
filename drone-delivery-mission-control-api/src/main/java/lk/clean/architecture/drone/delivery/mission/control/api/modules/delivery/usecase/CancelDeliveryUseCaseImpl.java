package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.models.Delivery;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.AssignDroneResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CancelDeliveryResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneAssignApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneExistenceCheckApi;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.UUID;

public class CancelDeliveryUseCaseImpl implements CancelDeliveryUseCase {

    //inject required dependencies
    private final DeliveryRepository deliveryRepository;
    private final DroneAssignApi droneAssignApi;

    public CancelDeliveryUseCaseImpl(
            DeliveryRepository deliveryRepository,
            DroneAssignApi droneAssignApi
    ) {
        this.deliveryRepository = deliveryRepository;
        this.droneAssignApi = droneAssignApi;
    }

    //create cancel delivery
    @Override
    public CancelDeliveryResult cancelDelivery(UUID deliveryId) {

        Delivery delivery = deliveryRepository.getDeliveryById(deliveryId)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery "+deliveryId+" not found"));

        LocalDateTime currentTime = LocalDateTime.now();
        //call domain cancel logic
        delivery.cancelDelivery(currentTime);

        //drone set back to available
        droneAssignApi.droneBackToAvailable(delivery.getAssignedDroneId());

        //save delivery
        deliveryRepository.save(delivery);

        return new CancelDeliveryResult(
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
