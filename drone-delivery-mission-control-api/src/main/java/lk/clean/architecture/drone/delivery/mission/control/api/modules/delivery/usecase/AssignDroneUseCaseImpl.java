package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.AssignDroneResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;

import java.util.UUID;

public class AssignDroneUseCaseImpl implements AssignDroneUseCase {

    //inject required dependencies
    private final DeliveryRepository deliveryRepository;

    public AssignDroneUseCaseImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    //assign a drone
    @Override
    public AssignDroneResult assignDrone(UUID droneId){

    }
}
