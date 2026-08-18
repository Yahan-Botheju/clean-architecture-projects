package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.infrastructure.configs;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.repositories.InventoryItemRepository;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.infrastructure.persistence.InventoryItemRepositoryImpl;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.infrastructure.persistence.jpa.JpaInventoryItemRepository;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.infrastructure.persistence.persistenceMapper.PersistenceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceBeanConfigs {
    //persistence bean config
    @Bean
    public InventoryItemRepository inventoryItemRepository(
            JpaInventoryItemRepository jpaInventoryItemRepository,
            PersistenceMapper persistenceMapper
    ) {
        return new InventoryItemRepositoryImpl(jpaInventoryItemRepository, persistenceMapper);
    }
}
