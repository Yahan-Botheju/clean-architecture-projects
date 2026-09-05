package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneExistenceCheck;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;

public class DroneExistenceCheckApiImpl extends AbstractDroneFindSupport implements DroneExistenceCheck {

    //inject abstract class
    public DroneExistenceCheckApiImpl(
            DroneRepository droneRepository
    ) {
        super(droneRepository);
    }

}
