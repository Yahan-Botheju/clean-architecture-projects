package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api;

import lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer.DroneBatteryCheckApiDTO;

import java.util.UUID;

public interface DroneBatteryCheckApi {

    //check drone battery status
    DroneBatteryCheckApiDTO checkDroneBatteryStatus(UUID droneId, double batteryPercentage);
}
