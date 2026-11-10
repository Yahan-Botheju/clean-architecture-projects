package lk.clean.architecture.smart.cart.order.management.system.modules.customer.infrastructure.persistence.jpa;

import lk.clean.architecture.smart.cart.order.management.system.modules.customer.infrastructure.persistence.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface JpaCustomerRepository extends JpaRepository<CustomerEntity, UUID> {

    boolean existsByCustomerId(UUID customerId);

    boolean existsByEmail(String email);

    Optional<CustomerEntity> findByCustomerEmail(String email);

    Optional<CustomerEntity> findByCustomerId(UUID customerId);

}
