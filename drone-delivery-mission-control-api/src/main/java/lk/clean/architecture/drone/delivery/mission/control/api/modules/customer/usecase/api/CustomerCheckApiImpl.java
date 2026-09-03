package lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.api.CustomerCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.domain.models.Customer;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.domain.repositories.CustomerRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer.CustomerCheckApiDTO;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.UUID;

public class CustomerCheckApiImpl implements CustomerCheckApi {

    //inject required dependencies
    private final  CustomerRepository customerRepository;

    public CustomerCheckApiImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //get customer by id
    @Override
    public CustomerCheckApiDTO getCustomerCheck(UUID customerId) {

        if(customerId == null){
            throw new ResourceNotFoundException("Customer ID cannot be empty");
        }

        //check customer existence
        Customer getCustomer = customerRepository.getCustomerById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + customerId));

        return new CustomerCheckApiDTO(
                getCustomer.getCustomerId(),
                getCustomer.getCustomerName(),
                getCustomer.getCustomerEmail(),
                getCustomer.getCustomerStatus()
        );
    }
}
