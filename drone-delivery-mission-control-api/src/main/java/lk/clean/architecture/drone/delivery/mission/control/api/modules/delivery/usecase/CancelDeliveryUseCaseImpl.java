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


}
