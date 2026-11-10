package lk.clean.architecture.smart.cart.order.management.system.modules.customer.domain.repositories;

import lk.clean.architecture.smart.cart.order.management.system.modules.customer.domain.models.Customer;

import java.util.Optional;
import java.util.UUID;

public interface CustomerRepository {

    //check customer existence
    boolean checkCustomerExistenceById(UUID customerId);

    //get customer by id
    Optional<Customer> getCustomerById(UUID customerId);

    //check customer existence by email
    boolean checkCustomerExistenceByEmail(String email);

    //check customer email existence
    Optional<Customer> getCustomerByEmail(String email);

    //save customer
    Customer saveCustomer(Customer customer);
}
