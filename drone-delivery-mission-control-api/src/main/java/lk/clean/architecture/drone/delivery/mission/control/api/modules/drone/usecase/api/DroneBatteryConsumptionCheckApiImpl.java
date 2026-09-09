package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneBatteryCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneBatteryConsumptionCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.models.Drone;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer.DroneBatteryCheckApiDTO;

import java.util.UUID;

public class DroneBatteryConsumptionCheckApiImpl extends AbstractDroneFindSupport implements DroneBatteryConsumptionCheckApi {

    //inject required dependencies
    public DroneBatteryConsumptionCheckApiImpl(DroneRepository droneRepository) {
        super(droneRepository);
    }

    //initiate battery consumption check method
    @Override
    public DroneBatteryCheckApiDTO droneBatteryConsumptionCheckApi(
            UUID droneId,
            double packageWeightKg
    ) {

        Drone getDrone = getDroneById(droneId);
        //call domain logic
        getDrone.reduceDroneBattery(packageWeightKg);

        return new DroneBatteryCheckApiDTO(
                getDrone.getDroneId(),
                getDrone.getSerialNumber(),
                getDrone.getDroneStatus(),
                getDrone.getBatteryPercentage()
        );
    }
}
