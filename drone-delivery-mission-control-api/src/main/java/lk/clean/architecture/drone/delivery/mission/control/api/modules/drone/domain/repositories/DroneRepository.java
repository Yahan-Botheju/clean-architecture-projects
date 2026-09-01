package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.repositories;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.models.Drone;

import java.util.Optional;
import java.util.UUID;

public interface DroneRepository {

    //drone find by id
    Optional<Drone> droneFindById(UUID uuid);
}
