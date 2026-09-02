package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api.DroneAssignApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.models.Drone;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories.DroneRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer.DroneAssignApiDTO;

import java.util.UUID;

public class DroneAssignApiImpl extends AbstractDroneFindSupport implements DroneAssignApi {

    //initiate abstract class
    public DroneAssignApiImpl(DroneRepository droneRepository) {
        super(droneRepository);
    }

    //inject required dependencies
    @Override
    public DroneAssignApiDTO droneAssign(UUID droneId, double packageWeight) {

        //get drone
        Drone getDrone = getDroneById(droneId);

         /*
         * __DOMAIN_LOGICS_USAGE__
         * check drone availability
         * assign drone
         */
        getDrone.checkDroneAvailability(packageWeight);
        getDrone.markAsAssignDrone();

        //save drone
        droneRepository.saveDrone(getDrone);

        return new DroneAssignApiDTO(
                getDrone.getDroneId(),
                getDrone.getSerialNumber(),
                getDrone.getDroneStatus(),
                getDrone.getMaxPayloadingKg(),
                getDrone.getBatteryPercentage()
        );
    }
}
