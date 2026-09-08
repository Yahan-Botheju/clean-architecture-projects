package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api;

import lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer.DroneExistenceCheckApiDTO;

import java.util.UUID;

public interface DroneExistenceCheckApi {

    //get drone details related to its id
    DroneExistenceCheckApiDTO checkDroneExistence(UUID droneId);


    //check drone existence by id
    boolean checkDroneExistenceById(UUID droneId);
}
