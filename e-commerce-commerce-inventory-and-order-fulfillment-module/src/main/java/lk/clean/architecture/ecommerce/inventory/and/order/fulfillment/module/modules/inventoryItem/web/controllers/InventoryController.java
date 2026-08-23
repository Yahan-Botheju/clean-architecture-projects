package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.web.controllers;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.usecase.CreateInventoryItemUseCase;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.usecase.RestockInventoryUseCase;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.web.webMappers.InventoryWebMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/inventory")
public class InventoryController {

    //inject required dependencies
    private final CreateInventoryItemUseCase createInventoryItemUseCase;
    private final RestockInventoryUseCase restockInventoryUseCase;
    private final InventoryWebMapper inventoryWebMapper;

    public InventoryController(
            CreateInventoryItemUseCase createInventoryItemUseCase,
            RestockInventoryUseCase restockInventoryUseCase,
            InventoryWebMapper inventoryWebMapper
    ) {
        this.createInventoryItemUseCase = createInventoryItemUseCase;
        this.restockInventoryUseCase = restockInventoryUseCase;
        this.inventoryWebMapper = inventoryWebMapper;
    }
}
