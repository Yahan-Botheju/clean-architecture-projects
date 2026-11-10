package lk.clean.architecture.smart.cart.order.management.system.modules.customer.usecase.api;

import lk.clean.architecture.smart.cart.order.management.system.modules.customer.api.CheckCustomerApi;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.domain.models.Customer;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.domain.repositories.CustomerRepository;
import lk.clean.architecture.smart.cart.order.management.system.shared_domain.customer_shared_api.CheckCustomerApiResult;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.util.UUID;

public class CheckCustomerApiImpl implements CheckCustomerApi {

    //inject required dependencies
    private final CustomerRepository customerRepository;

    public CheckCustomerApiImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    //check customer existence by id
    @Override
    public CheckCustomerApiResult checkCustomerByCustomerId(UUID customerId) {

        Customer getCustomer = customerRepository. getCustomerById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + customerId));

        getCustomer.suspendedCustomer();

        return new CheckCustomerApiResult(
                getCustomer.getCustomerId(),
                getCustomer.getFullName(),
                getCustomer.getEmail(),
                getCustomer.getCustomerStatus(),
                getCustomer.getCreatedAt()
        );
    }
}
