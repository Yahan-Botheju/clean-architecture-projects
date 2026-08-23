package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.web.DTOs;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateInventoryRequestDTO {
    @NotBlank(message = "Product name cannot be empty ")
    private String productName;

    @NotNull(message = "Available stock cannot be empty or zero")
    @Min(1)
    private int availableStock;

    @Min(1)
    @DecimalMin("0.01")
    private BigDecimal unitPrice;
}
