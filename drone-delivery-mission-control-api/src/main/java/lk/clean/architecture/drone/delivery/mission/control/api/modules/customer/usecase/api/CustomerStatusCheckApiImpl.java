package lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.api.CustomerStatusCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.domain.models.Customer;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.domain.repositories.CustomerRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.UUID;

public class CustomerStatusCheckApiImpl implements CustomerStatusCheckApi {

    //inject required dependencies
    private final CustomerRepository customerRepository;

    public CustomerStatusCheckApiImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //check customer is active
    @Override
    public boolean checkCustomerStatus(UUID customerId) {
        //check customer id is available
        if(customerId == null){
            throw new ResourceNotFoundException("Customer Id cannot be empty");
        }
        //get customer
        Customer checkCustomer = customerRepository.getCustomerById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found"));
        //check customer is active
        return checkCustomer.isActive();
    }
}
