package lk.clean.architecture.cart.system.ex02.modules.catalog.web.DTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequestDTO {

    @NotBlank(message = "Product name is required")
    private String productName;

    @Min(1)
    @NotNull(message = "Unit price is required")
    private double unitPrice;

    @Min(5)
    @NotNull(message = "Initial stock is required")
    private int initialStock;
}
