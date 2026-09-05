package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;

public class AssignDroneUseCaseImpl implements AssignDroneUseCase {

    //inject required dependencies
    private final DroneRepository droneRepository;

    public AssignDroneUseCaseImpl(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }
}
