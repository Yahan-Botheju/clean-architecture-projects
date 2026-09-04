package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.AssignDroneResult;

import java.util.UUID;

public interface AssignDroneUseCase {

    //assign a drone
    AssignDroneResult assignDrone(UUID droneId);
}
