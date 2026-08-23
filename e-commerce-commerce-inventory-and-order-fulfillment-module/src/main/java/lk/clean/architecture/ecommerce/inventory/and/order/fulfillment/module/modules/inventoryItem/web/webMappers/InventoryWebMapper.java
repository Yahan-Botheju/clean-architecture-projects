package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.web.webMappers;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.modules.InventoryItem;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.web.DTOs.InventoryResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface InventoryWebMapper {

    //domain model to dto
    InventoryResponseDTO toRecordDTO(InventoryItem inventoryItem);
}
