package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.infrastructure.configs;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.api.InventoryModuleApi;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.repositories.InventoryItemRepository;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.repositories.OrderRepository;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.usecase.*;
import org.springframework.context.annotation.Bean;

public class UseCaseBeanConfigs {

    //place order usecase impl
    @Bean
    public PlaceOrderUseCase placeOrderUseCase(
            OrderRepository orderRepository,
            InventoryModuleApi inventoryModuleApi
    ){
        return new PlaceOrderUseCaseImpl(orderRepository, inventoryModuleApi);
    }

    //confirm order usecase impl
    @Bean
    public ConfirmOrderUseCase confirmOrderUseCase(
            OrderRepository orderRepository
    ){
        return new ConfirmOrderUseCaseImpl(orderRepository);
    }

    //ship order usecase impl
    @Bean
    public ShipOrderUseCase shipOrderUseCase(
            OrderRepository orderRepository,
            InventoryModuleApi inventoryModuleApi
    ){
        return new ShipOrderUseCaseImpl(orderRepository, inventoryModuleApi);
    }
}
