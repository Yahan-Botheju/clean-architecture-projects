package lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.domain.repositories;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.domain.models.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

    //check customer existence and get
    Optional<Customer> getCustomer(UUID customerId);
}
