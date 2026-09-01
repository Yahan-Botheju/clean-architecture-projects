package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneTaskCompleteApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.models.Drone;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.UUID;

public class DroneTaskCompleteApiImpl implements DroneTaskCompleteApi {

    //inject required dependencies
    private DroneRepository droneRepository;

    public DroneTaskCompleteApiImpl(DroneRepository droneRepository) {
        this.droneRepository=droneRepository;
    }

    //When drone delivery task is complete
    @Override
    public void droneTaskComplete(UUID droneId){

        //check drone existence
        Drone getDrone = droneRepository.droneFindById(droneId)
                .orElseThrow(() -> new ResourceNotFoundException("Drone not found!"));

        //call domain method
        getDrone.markAsCompleteDroneMission();

        droneRepository.saveDrone(getDrone);
    }
}
