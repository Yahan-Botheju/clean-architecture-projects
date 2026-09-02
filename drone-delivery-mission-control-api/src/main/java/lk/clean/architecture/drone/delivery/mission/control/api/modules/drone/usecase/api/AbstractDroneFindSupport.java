package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.models.Drone;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.UUID;

public abstract class AbstractDroneFindSupport {

    //inject required dependencies
    protected final DroneRepository droneRepository;

    protected AbstractDroneFindSupport(DroneRepository droneRepository) {
        this.droneRepository = droneRepository;
    }

    //get drone by it id
    protected Drone getDroneById(UUID droneId) {
        return droneRepository.droneFindById(droneId)
                .orElseThrow(() -> new ResourceNotFoundException("Drone not found with id " + droneId));
    }
}
