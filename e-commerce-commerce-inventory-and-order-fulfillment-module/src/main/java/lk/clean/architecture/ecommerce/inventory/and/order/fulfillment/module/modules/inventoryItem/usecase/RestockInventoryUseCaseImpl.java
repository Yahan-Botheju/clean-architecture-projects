package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.usecase;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.modules.InventoryItem;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.repositories.InventoryItemRepository;

import java.time.LocalDateTime;
import java.util.UUID;

public class RestockInventoryUseCaseImpl implements RestockInventoryUseCase {

    //inject required dependencies
    private final InventoryItemRepository inventoryItemRepository;

    public RestockInventoryUseCaseImpl(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    //restock inventory item
    @Override
    public InventoryItem restockInventoryItem(UUID productId, int addedQuantity) {

        InventoryItem checkProduct = inventoryItemRepository.findByProductId(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        LocalDateTime currentTime = LocalDateTime.now();
        //use domain logic
        checkProduct.restock(addedQuantity, currentTime);

        return inventoryItemRepository.save(checkProduct);
    }
}
