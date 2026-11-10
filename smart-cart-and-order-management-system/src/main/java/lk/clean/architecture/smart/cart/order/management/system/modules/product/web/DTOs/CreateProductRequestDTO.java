package lk.clean.architecture.smart.cart.order.management.system.modules.product.web.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequestDTO {

    @NotBlank(message = "SKU cannot be empty")
    private String sku;

    @NotBlank(message = "Product name cannot be empty")
    private String productName;

    @NotBlank(message = "Product description cannot be empty")
    private String productDescription;

    @NotNull(message = "Product description cannot be empty")
    private BigDecimal productPrice;
}
