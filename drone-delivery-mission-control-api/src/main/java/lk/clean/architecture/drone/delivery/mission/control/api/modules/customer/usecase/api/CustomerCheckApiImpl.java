package lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.api.CustomerCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.domain.repositories.CustomerRepository;

public class CustomerCheckApiImpl implements CustomerCheckApi {

    //inject required dependencies
    private final  CustomerRepository customerRepository;

    public CustomerCheckApiImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
}
