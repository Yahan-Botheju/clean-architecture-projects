package lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.api;

import lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer.CustomerCheckApiDTO;

import java.util.UUID;

public interface CustomerCheckApi {

    //get customer by id
    CustomerCheckApiDTO getCustomerCheck(UUID customerId);
}
