package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.repositories;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.modules.InventoryItem;

public interface InventoryItemRepository {

    //create new item
    InventoryItem createNewItem(InventoryItem inventoryItem);
}
