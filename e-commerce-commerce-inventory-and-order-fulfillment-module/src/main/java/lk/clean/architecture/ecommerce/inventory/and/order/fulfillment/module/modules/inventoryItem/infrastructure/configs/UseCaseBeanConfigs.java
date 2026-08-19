package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.infrastructure.configs;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.repositories.InventoryItemRepository;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.usecase.CreateInventoryItemUseCase;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.usecase.CreateInventoryItemUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfigs {

    //create inventory item impl
    @Bean
    public CreateInventoryItemUseCase createInventoryItemUseCase(
            InventoryItemRepository inventoryItemRepository
    ) {
        return new CreateInventoryItemUseCaseImpl(inventoryItemRepository);
    }
}
