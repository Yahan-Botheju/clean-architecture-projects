package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.web.controllers;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.modules.InventoryItem;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.usecase.CreateInventoryItemUseCase;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.usecase.RestockInventoryUseCase;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.web.DTOs.CreateInventoryRequestDTO;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.web.DTOs.InventoryResponseDTO;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.web.DTOs.RestockInventoryRequestDTO;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.web.webMappers.InventoryWebMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    //create inventory
    @PostMapping
    public ResponseEntity<InventoryResponseDTO> createInventoryItem(
            @RequestBody CreateInventoryRequestDTO createInventoryRequestDTO
            ){
        //set values to usecase
        InventoryItem toUseCase = createInventoryItemUseCase.createInventoryItem(
                createInventoryRequestDTO.getProductName(),
                createInventoryRequestDTO.getAvailableStock(),
                createInventoryRequestDTO.getUnitPrice()
        );
        InventoryResponseDTO responseDTO = inventoryWebMapper.toRecordDTO(toUseCase);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    //restock inventory
    @PatchMapping("/{productId}/restock")
    public ResponseEntity<InventoryResponseDTO> restockInventoryItem(
            @PathVariable UUID productId,
            @RequestBody RestockInventoryRequestDTO restockInventoryRequestDTO
    ){
        //set values to usecase
        InventoryItem toUseCase = restockInventoryUseCase.restockInventoryItem(
                productId,
                restockInventoryRequestDTO.getAddedQuantity()
        );
        InventoryResponseDTO responseDTO = inventoryWebMapper.toRecordDTO(toUseCase);

        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }
}
