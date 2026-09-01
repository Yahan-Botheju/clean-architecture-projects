package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.persistence.jpa;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.persistence.entities.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaDeliveryRepository extends JpaRepository<DeliveryEntity, UUID> {
}
