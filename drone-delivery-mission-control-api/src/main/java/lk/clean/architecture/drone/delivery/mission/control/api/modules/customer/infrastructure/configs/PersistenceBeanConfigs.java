package lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.infrastructure.configs;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.domain.repositories.CustomerRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.infrastructure.persistence.CustomerRepositoryImpl;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.infrastructure.persistence.jpa.JpaCustomerRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.infrastructure.persistence.persistenceMappers.CustomerPersistenceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceBeanConfigs {

    //customer persistence impl
    @Bean
    public CustomerRepository customerRepository(
            JpaCustomerRepository jpaCustomerRepository,
            CustomerPersistenceMapper  customerPersistenceMapper
    ) {
        return new CustomerRepositoryImpl(jpaCustomerRepository, customerPersistenceMapper);
    }
}
