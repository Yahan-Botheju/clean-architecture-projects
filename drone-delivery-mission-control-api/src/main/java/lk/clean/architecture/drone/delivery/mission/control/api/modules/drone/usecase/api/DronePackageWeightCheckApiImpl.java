package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DronePackageWeightCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;

public class DronePackageWeightCheckApiImpl implements DronePackageWeightCheckApi {

    //inject required dependencies
    private final DroneRepository droneRepository;

    public DronePackageWeightCheckApiImpl(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }
}
