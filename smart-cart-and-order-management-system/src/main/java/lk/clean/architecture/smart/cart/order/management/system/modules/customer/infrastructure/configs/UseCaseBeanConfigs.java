package lk.clean.architecture.smart.cart.order.management.system.modules.customer.infrastructure.configs;

import lk.clean.architecture.smart.cart.order.management.system.modules.customer.api.CheckCustomerApi;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.domain.repositories.CustomerRepository;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.usecase.RegisterCustomerUseCase;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.usecase.RegisterCustomerUseCaseImpl;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.usecase.api.CheckCustomerApiImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfigs {

    /* __EXTERNAL_API__ */

    @Bean
    public CheckCustomerApi checkCustomerApi(
            CustomerRepository customerRepository
    ){
        return new CheckCustomerApiImpl(customerRepository);
    }


    //register customer impl
    @Bean
    public RegisterCustomerUseCase registerCustomer(
            CustomerRepository customerRepository
    ) {
        return new RegisterCustomerUseCaseImpl(customerRepository);
    }


}
