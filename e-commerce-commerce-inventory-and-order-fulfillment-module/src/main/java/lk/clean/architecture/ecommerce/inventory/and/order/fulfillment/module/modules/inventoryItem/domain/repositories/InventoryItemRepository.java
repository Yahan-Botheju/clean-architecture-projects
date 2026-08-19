package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.repositories;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.modules.InventoryItem;

import java.util.Optional;
import java.util.UUID;

public interface InventoryItemRepository {

    //check product by id
    Optional<InventoryItem> findByProductId(UUID productId);

    //create new item
    InventoryItem createNewItem(InventoryItem inventoryItem);
}
