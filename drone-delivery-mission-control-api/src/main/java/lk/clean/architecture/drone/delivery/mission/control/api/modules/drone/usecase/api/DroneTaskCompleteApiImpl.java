package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneTaskCompleteApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.models.Drone;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;

import java.util.UUID;

public class DroneTaskCompleteApiImpl extends AbstractDroneFindSupport implements DroneTaskCompleteApi {

    //initiate abstract class through the method
    public DroneTaskCompleteApiImpl(DroneRepository droneRepository) {
        super(droneRepository);
    }

    //When drone delivery task is complete
    @Override
    public void droneTaskComplete(UUID droneId){

        //check drone existence
        Drone getDrone = getDroneById(droneId);

        //call domain method
        getDrone.markAsCompleteDroneMission();

        droneRepository.saveDrone(getDrone);
    }
}
