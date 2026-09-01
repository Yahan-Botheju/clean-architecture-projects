package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneAssignApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;

public class DroneAssignApiImpl implements DroneAssignApi {

    //inject required dependencies
    private final DroneRepository droneRepository;

    public DroneAssignApiImpl(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }
}
