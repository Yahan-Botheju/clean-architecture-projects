package lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.infrastructure.configs;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.api.CustomerCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.domain.repositories.CustomerRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.usecase.api.CustomerCheckApiImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfigs {

    //external api
    @Bean
    public CustomerCheckApi  customerCheckApi(CustomerRepository customerRepository) {
        return new CustomerCheckApiImpl(customerRepository);
    }
}
