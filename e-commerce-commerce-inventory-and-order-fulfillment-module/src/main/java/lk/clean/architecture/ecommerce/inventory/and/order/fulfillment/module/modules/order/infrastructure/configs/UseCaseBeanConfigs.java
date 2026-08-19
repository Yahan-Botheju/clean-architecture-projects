package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.infrastructure.configs;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.repositories.OrderRepository;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.usecase.PlaceOrderUseCase;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.usecase.PlaceOrderUseCaseImpl;
import org.springframework.context.annotation.Bean;

public class UseCaseBeanConfigs {

    //place order usecase impl
    @Bean
    public PlaceOrderUseCase placeOrderUseCase(
            OrderRepository orderRepository
    ){
        return new PlaceOrderUseCaseImpl(orderRepository);
    }
}
