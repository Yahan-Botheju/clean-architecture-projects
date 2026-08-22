package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.usecase;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.repositories.InventoryItemRepository;

public class RestockInventoryUseCaseImpl implements RestockInventoryUseCase {

    //inject required dependencies
    private final InventoryItemRepository inventoryItemRepository;

    public RestockInventoryUseCaseImpl(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }
}
