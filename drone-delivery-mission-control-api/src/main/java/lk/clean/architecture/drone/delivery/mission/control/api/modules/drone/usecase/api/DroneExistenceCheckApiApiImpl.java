package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneExistenceCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.models.Drone;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer.DroneExistenceCheckApiDTO;

import java.util.UUID;

public class DroneExistenceCheckApiApiImpl extends AbstractDroneFindSupport implements DroneExistenceCheckApi {

    //inject abstract class
    public DroneExistenceCheckApiApiImpl(
            DroneRepository droneRepository
    ) {
        super(droneRepository);
    }

    //check drone existence
    @Override
    public DroneExistenceCheckApiDTO checkDroneExistence(UUID droneId) {

        //check drone existence
        Drone checkDroneExistence = getDroneById(droneId);

        return new DroneExistenceCheckApiDTO(
                checkDroneExistence.getDroneId(),
                checkDroneExistence.getSerialNumber(),
                checkDroneExistence.getDroneStatus(),
                checkDroneExistence.getMaxPayloadingKg(),
                checkDroneExistence.getBatteryPercentage()
        );
    }

}
