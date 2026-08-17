package lk.clean.architecture.ecommerce.order.processing.module.infrastructure.configs;

import lk.clean.architecture.ecommerce.order.processing.module.domain.repositories.OrderRepository;
import lk.clean.architecture.ecommerce.order.processing.module.usecase.order.ConfirmOrderUseCase;
import lk.clean.architecture.ecommerce.order.processing.module.usecase.order.ConfirmOrderUseCaseImpl;
import lk.clean.architecture.ecommerce.order.processing.module.usecase.order.CreateOrderUseCase;
import lk.clean.architecture.ecommerce.order.processing.module.usecase.order.CreateOrderUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfigs {
    //create order usecase
    @Bean
    public CreateOrderUseCase createOrderUseCase(
            OrderRepository orderRepository
    ) {
        return new CreateOrderUseCaseImpl(orderRepository);
    }

    //confirm order usecase
    @Bean
    public ConfirmOrderUseCase confirmOrderUseCase(
            OrderRepository orderRepository
    ){
        return new ConfirmOrderUseCaseImpl(orderRepository);
    }
}
