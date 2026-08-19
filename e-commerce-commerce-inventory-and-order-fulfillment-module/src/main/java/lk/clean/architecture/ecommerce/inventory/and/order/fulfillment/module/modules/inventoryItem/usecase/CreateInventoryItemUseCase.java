package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.usecase;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.modules.InventoryItem;

import java.math.BigDecimal;

public interface CreateInventoryItemUseCase {

    //create new item
    InventoryItem createInventoryItem(String productName, int availableStock, BigDecimal unitPrice);
}
