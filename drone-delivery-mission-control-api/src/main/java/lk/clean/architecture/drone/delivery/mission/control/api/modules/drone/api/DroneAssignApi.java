package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api;

import lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer.DroneAssignApiDTO;

import java.util.UUID;

public interface DroneAssignApi {

    //inject required dependencies
    public DroneAssignApiDTO droneAssign(UUID droneId, double packageWeight);
}
