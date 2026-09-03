package lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.domain.repositories.CustomerRepository;

public class CustomerStatusCheckApiImpl {

    //inject required dependencies
    private final CustomerRepository customerRepository;

    public CustomerStatusCheckApiImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
