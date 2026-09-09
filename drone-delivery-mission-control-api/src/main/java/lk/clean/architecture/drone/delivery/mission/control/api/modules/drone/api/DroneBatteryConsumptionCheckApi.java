package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api;

import lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer.DroneBatteryCheckApiDTO;

import java.util.UUID;

public interface DroneBatteryConsumptionCheckApi {

    //initiate battery consumption check method
    DroneBatteryCheckApiDTO droneBatteryConsumptionCheckApi(UUID droneId, double packageWeightKg);
}
