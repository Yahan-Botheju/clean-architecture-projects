package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.infrastructure.persistence.persistenceMapper;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.modules.InventoryItem;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.infrastructure.persistence.entities.InventoryItemEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersistenceMapper {

    //domain model to entity
    InventoryItemEntity toEntity(InventoryItem inventoryItem);

    //entity to domain model
    InventoryItem toDomainModel(InventoryItemEntity inventoryItemEntity);
}
