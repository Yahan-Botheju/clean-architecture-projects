package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneTaskFailApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.models.Drone;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.UUID;

public class DroneTaskFailApiImpl implements DroneTaskFailApi {

    //inject required dependencies
    private final DroneRepository droneRepository;

    public DroneTaskFailApiImpl(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    @Override
    public void droneTaskFail(UUID droneId) {
        //check drone existence
        Drone checkDrone = droneRepository.droneFindById(droneId)
                .orElseThrow(() -> new ResourceNotFoundException("Drone not found!"));
        //call domain logic
        checkDrone.markAsFailedDroneMission();
        //save drone activity
        droneRepository.saveDrone(checkDrone);
    }
}
