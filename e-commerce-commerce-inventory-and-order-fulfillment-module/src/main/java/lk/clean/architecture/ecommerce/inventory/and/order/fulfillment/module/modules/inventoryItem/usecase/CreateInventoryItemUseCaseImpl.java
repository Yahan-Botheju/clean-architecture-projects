package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.usecase;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.modules.InventoryItem;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.repositories.InventoryItemRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class CreateInventoryItemUseCaseImpl implements  CreateInventoryItemUseCase {

    //inject required dependencies
    private final InventoryItemRepository inventoryItemRepository;

    public CreateInventoryItemUseCaseImpl(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    //create new item
    @Override
    public InventoryItem createInventoryItem(
            String productName,
            int availableStock,
            BigDecimal unitPrice
    ) {
        //check required params are initiated correctly
        if(productName == null || availableStock<=0 || unitPrice.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalStateException("Some fields are missing");
        }
        //create ID and create time
        UUID productId = UUID.randomUUID();
        LocalDateTime currentTime = LocalDateTime.now();

        //initiate obj
        InventoryItem newInventoryItem = new InventoryItem(
                productId,
                productName,
                availableStock,
                unitPrice,
                0,
                currentTime
        );

        //save and return
        return inventoryItemRepository.createNewItem(newInventoryItem);
    }
}
