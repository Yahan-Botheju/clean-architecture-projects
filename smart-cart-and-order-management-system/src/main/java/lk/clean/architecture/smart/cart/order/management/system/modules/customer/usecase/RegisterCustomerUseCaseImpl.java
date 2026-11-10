package lk.clean.architecture.smart.cart.order.management.system.modules.customer.usecase;

import lk.clean.architecture.smart.cart.order.management.system.modules.customer.domain.enums.CustomerStatus;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.domain.models.Customer;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.domain.repositories.CustomerRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.usecase.records.CustomerRegisterCommand;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.usecase.records.CustomerRegisterResult;

import java.time.LocalDateTime;

public class RegisterCustomerUseCaseImpl implements RegisterCustomerUseCase {

    //inject required dependencies
    private final CustomerRepository customerRepository;

    public RegisterCustomerUseCaseImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    //customer registration
    @Override
    public CustomerRegisterResult registerCustomer(CustomerRegisterCommand customerRegisterCommand) {

        //check customer is existing
       if(customerRepository.checkCustomerExistenceByEmail(customerRegisterCommand.email())){
           throw new IllegalStateException("Email already exists");
       }

       /* __create_new_customer_model__ */

        LocalDateTime currentDateTime = LocalDateTime.now();

        Customer newCustomer = Customer.createNewCustomer(
                customerRegisterCommand.fullName(),
                customerRegisterCommand.email(),
                CustomerStatus.ACTIVE,
                currentDateTime
        );

        //save customer
        customerRepository.saveCustomer(newCustomer);

        return new CustomerRegisterResult(
                newCustomer.getCustomerId(),
                newCustomer.getFullName(),
                newCustomer.getEmail(),
                newCustomer.getCustomerStatus(),
                newCustomer.getCreatedAt()
        );
    }
}
