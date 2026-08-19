package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.usecase;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.repositories.InventoryItemRepository;

public class CreateInventoryItemUseCaseImpl implements  CreateInventoryItemUseCase {

    //inject required dependencies
    private final InventoryItemRepository inventoryItemRepository;

    public CreateInventoryItemUseCaseImpl(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }
}
