package lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.infrastructure.persistence.jpa;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.infrastructure.persistence.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, UUID> {
}
