package lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.infrastructure.configs;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.api.CustomerStatusCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.domain.repositories.CustomerRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.usecase.api.CustomerStatusCheckApiImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfigs {

    //external api
    @Bean
    public CustomerStatusCheckApi customerStatusCheckApi(CustomerRepository customerRepository) {
        return new CustomerStatusCheckApiImpl(customerRepository);
    }
}
