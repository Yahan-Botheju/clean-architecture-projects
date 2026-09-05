package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneBatteryCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.models.Drone;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer.DroneBatteryCheckApiDTO;

import java.util.UUID;

public class DroneBatteryCheckApiImpl extends AbstractDroneFindSupport implements DroneBatteryCheckApi {

    //inject abstract class
    protected DroneBatteryCheckApiImpl(DroneRepository droneRepository) {
        super(droneRepository);
    }

    //check drone battery status
    @Override
    public DroneBatteryCheckApiDTO checkDroneBatteryStatus(UUID droneId, double batteryPercentage){
        //check drone existence
        Drone checkDrone = getDroneById(droneId);
        //use domain battery check logic
        checkDrone.checkDroneBattery(batteryPercentage);

        return new DroneBatteryCheckApiDTO(
                checkDrone.getDroneId(),
                checkDrone.getSerialNumber(),
                checkDrone.getDroneStatus(),
                checkDrone.getBatteryPercentage()
        );
    }
}
