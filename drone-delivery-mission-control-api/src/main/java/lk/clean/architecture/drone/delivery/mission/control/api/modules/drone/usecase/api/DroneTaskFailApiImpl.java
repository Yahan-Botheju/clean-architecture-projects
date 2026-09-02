package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneTaskFailApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.models.Drone;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;

import java.util.UUID;

public class DroneTaskFailApiImpl extends AbstractDroneFindSupport implements DroneTaskFailApi {

    //initiate abstract class
    public DroneTaskFailApiImpl(DroneRepository droneRepository) {
        super(droneRepository);
    }

    @Override
    public void droneTaskFail(UUID droneId) {
        //check drone existence
        Drone checkDrone = getDroneById(droneId);
        //call domain logic
        checkDrone.markAsFailedDroneMission();
        //save drone activity
        droneRepository.saveDrone(checkDrone);
    }
}
