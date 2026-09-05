package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DronePackageWeightCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.models.Drone;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer.DronePackageWeightCheckApiDTO;

import java.util.UUID;

public class DronePackageWeightCheckApiImpl extends AbstractDroneFindSupport implements DronePackageWeightCheckApi {

    //initiate abstract class
    public DronePackageWeightCheckApiImpl(DroneRepository droneRepository) {
       super(droneRepository);
    }

    //drone carrying package weight check
    @Override
    public DronePackageWeightCheckApiDTO checkDronePackageWeight(UUID droneId, double packageWeightKg) {

        //check drone
        Drone checkDrone = getDroneById(droneId);
        //use domain logic
        checkDrone.checkDronePackageWeight(packageWeightKg);

        return  new DronePackageWeightCheckApiDTO(
                checkDrone.getDroneId(),
                checkDrone.getSerialNumber(),
                checkDrone.getMaxPayloadingKg()
        );
    }
}
