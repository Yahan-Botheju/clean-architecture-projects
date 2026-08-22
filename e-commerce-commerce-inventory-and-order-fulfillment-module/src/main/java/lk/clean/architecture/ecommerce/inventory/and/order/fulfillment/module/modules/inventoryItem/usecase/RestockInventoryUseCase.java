package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.usecase;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.modules.InventoryItem;

import java.util.UUID;

public interface RestockInventoryUseCase {

    //restock inventory
    InventoryItem restockInventoryItem(UUID productId, int addedQuantity);
}
