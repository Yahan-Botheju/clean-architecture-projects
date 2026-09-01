package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneTaskCompleteApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;

public class DroneTaskCompleteApiImpl implements DroneTaskCompleteApi {

    //inject required dependencies
    private DroneRepository droneRepository;

    public DroneTaskCompleteApiImpl(DroneRepository droneRepository) {
        this.droneRepository=droneRepository;
    }
}
