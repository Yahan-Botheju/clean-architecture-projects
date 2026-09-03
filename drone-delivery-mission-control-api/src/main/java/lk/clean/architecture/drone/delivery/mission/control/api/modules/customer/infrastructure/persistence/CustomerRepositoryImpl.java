package lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.infrastructure.persistence;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.domain.repositories.CustomerRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.infrastructure.persistence.jpa.JpaCustomerRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.infrastructure.persistence.persistenceMappers.CustomerPersistenceMapper;

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
}
