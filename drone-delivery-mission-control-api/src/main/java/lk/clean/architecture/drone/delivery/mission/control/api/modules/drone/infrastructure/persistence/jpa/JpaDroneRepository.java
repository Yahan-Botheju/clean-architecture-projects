package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.infrastructure.persistence.jpa;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.infrastructure.persistence.entities.DroneEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaDroneRepository extends JpaRepository<DroneEntity, UUID> {
}
