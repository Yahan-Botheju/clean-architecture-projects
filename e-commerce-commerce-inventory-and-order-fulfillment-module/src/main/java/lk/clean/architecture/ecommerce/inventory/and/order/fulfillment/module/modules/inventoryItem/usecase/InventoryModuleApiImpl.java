package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.usecase;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.api.InventoryModuleApi;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.modules.InventoryItem;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.repositories.InventoryItemRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class InventoryModuleApiImpl implements InventoryModuleApi {

    //inject required dependencies
    private final InventoryItemRepository inventoryItemRepository;

    public InventoryModuleApiImpl(InventoryItemRepository inventoryItemRepository) {
        this.inventoryItemRepository = inventoryItemRepository;
    }

    //stock reservation
    @Override
    public void stockReservation(
            UUID productId,
            int requestedQuantity,
            LocalDateTime currentTime
    ){
        InventoryItem checkProduct = inventoryItemRepository.findByProductId(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        //call domain logic
        checkProduct.stockReservation(requestedQuantity, currentTime);

        inventoryItemRepository.save(checkProduct);
    }

    //unit price for order domain usecase impl
    @Override
    public BigDecimal getUnitPrice(UUID productId){

        InventoryItem checkProduct = inventoryItemRepository.findByProductId(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        //unit price related to product
        return checkProduct.getUnitPrice();
    }

    public
}
