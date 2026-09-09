package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneBatteryConsumptionCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;

public class DroneBatteryConsumptionCheckApiImpl extends AbstractDroneFindSupport implements DroneBatteryConsumptionCheckApi {

    //inject required dependencies
    public DroneBatteryConsumptionCheckApiImpl(DroneRepository droneRepository) {
        super(droneRepository);
    }
}
