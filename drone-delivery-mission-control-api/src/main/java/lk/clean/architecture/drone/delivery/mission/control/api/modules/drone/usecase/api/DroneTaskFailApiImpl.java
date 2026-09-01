package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneTaskFailApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;

public class DroneTaskFailApiImpl implements DroneTaskFailApi {

    //inject required dependencies
    private final DroneRepository droneRepository;

    public DroneTaskFailApiImpl(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }
}
