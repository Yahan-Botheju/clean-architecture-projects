package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneBatteryCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;

public class DroneBatteryCheckApiImpl extends AbstractDroneFindSupport implements DroneBatteryCheckApi {

    //inject abstract class
    protected DroneBatteryCheckApiImpl(DroneRepository droneRepository) {
        super(droneRepository);
    }
}
