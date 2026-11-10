package lk.clean.architecture.smart.cart.order.management.system.modules.product.web.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeProductPriceRequestDTO {

    @NotNull(message = "Product ID cannot be empty")
    UUID productId;

    @NotBlank(message = "Product name cannot be empty")
    String productName;

    @NotNull(message = "Product price cannot be empty")
    BigDecimal productPrice;
}
