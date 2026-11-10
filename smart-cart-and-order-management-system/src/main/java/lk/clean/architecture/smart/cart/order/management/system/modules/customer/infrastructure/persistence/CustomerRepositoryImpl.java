package lk.clean.architecture.smart.cart.order.management.system.modules.customer.infrastructure.persistence;

import lk.clean.architecture.smart.cart.order.management.system.modules.customer.domain.models.Customer;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.domain.repositories.CustomerRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.infrastructure.persistence.entities.CustomerEntity;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.infrastructure.persistence.jpa.JpaCustomerRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.infrastructure.persistence.persistenceMapper.CustomerPersistenceMapper;

import java.util.Optional;
import java.util.UUID;

public class CustomerRepositoryImpl implements CustomerRepository {

    //inject required dependencies
    private final JpaCustomerRepository jpaCustomerRepository;
    private final CustomerPersistenceMapper customerPersistenceMapper;

    public CustomerRepositoryImpl(
            JpaCustomerRepository jpaCustomerRepository,
            CustomerPersistenceMapper customerPersistenceMapper
    ) {
        this.jpaCustomerRepository = jpaCustomerRepository;
        this.customerPersistenceMapper = customerPersistenceMapper;
    }

    //check customer existence by id
    @Override
    public boolean checkCustomerExistenceById(UUID customerId) {
        return jpaCustomerRepository.existsById(customerId);
    }

    //get customer by customer id
    @Override
    public Optional<Customer> getCustomerById(UUID customerId) {
        return jpaCustomerRepository.findByCustomerId(customerId)
                .map(customerPersistenceMapper::toDomainModel);
    }

    //check customer existence by email
    @Override
    public boolean checkCustomerExistenceByEmail(String email) {
        return jpaCustomerRepository.existsByEmail(email);
    }

    //check customer existence by email
    @Override
    public Optional<Customer> getCustomerByEmail(String email) {
        return jpaCustomerRepository.findByCustomerEmail(email)
                .map(customerPersistenceMapper::toDomainModel);
    }

    //save customer
    @Override
    public Customer saveCustomer(Customer customer){

        CustomerEntity customerEntity = customerPersistenceMapper.toEntity(customer);
        CustomerEntity savedCustomerEntity = jpaCustomerRepository.save(customerEntity);

        return customerPersistenceMapper.toDomainModel(savedCustomerEntity);
    }
}
