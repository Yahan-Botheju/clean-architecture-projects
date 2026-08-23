package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.web.DTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestockInventoryRequestDTO {

    @NotNull(message = "Added quantity cannot be empty")
    @Min(1)
    private int addedQuantity;

}
