package lk.clean.architecture.smart.cart.order.management.system.modules.customer.infrastructure.configs;

import lk.clean.architecture.smart.cart.order.management.system.modules.customer.domain.repositories.CustomerRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.infrastructure.persistence.CustomerRepositoryImpl;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.infrastructure.persistence.jpa.JpaCustomerRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.infrastructure.persistence.persistenceMapper.CustomerPersistenceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceBeanConfigs {

    @Bean
    public CustomerRepository customerRepository(
            JpaCustomerRepository jpaCustomerRepository,
            CustomerPersistenceMapper customerPersistenceMapper
    ) {
        return new CustomerRepositoryImpl(jpaCustomerRepository, customerPersistenceMapper);
    }
}
