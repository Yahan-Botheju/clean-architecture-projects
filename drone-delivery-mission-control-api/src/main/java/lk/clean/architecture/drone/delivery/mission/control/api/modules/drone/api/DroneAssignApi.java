package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api;

import lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer.DroneAssignApiDTO;
import lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer.DroneStatusApiDTO;

import java.util.UUID;

public interface DroneAssignApi {

    //inject required dependencies
    DroneAssignApiDTO droneAssign(UUID droneId, double packageWeight);

    //assign drone for mission
    DroneAssignApiDTO droneAssignForMission(UUID droneId);

    //drone set back to available
    DroneStatusApiDTO droneBackToAvailable(UUID droneId); /* __#7 COMMIT -> Initiate the method __  DroneAssignApi.java */
}
