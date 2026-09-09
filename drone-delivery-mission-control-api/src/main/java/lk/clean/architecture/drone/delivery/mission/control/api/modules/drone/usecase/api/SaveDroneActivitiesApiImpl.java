package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.SaveDroneActivitiesApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;

public class SaveDroneActivitiesApiImpl extends AbstractDroneFindSupport implements SaveDroneActivitiesApi {

    //initiate abstract method
    public SaveDroneActivitiesApiImpl(DroneRepository droneRepository) {
        super(droneRepository);
    }
}
