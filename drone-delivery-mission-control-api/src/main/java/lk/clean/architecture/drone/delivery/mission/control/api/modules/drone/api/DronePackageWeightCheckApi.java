package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api;

import lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer.DronePackageWeightCheckApiDTO;

import java.util.UUID;

public interface DronePackageWeightCheckApi {

    //drone carrying package weight check
    DronePackageWeightCheckApiDTO checkDronePackageWeight(UUID droneId, double packageWeightKg);
}
