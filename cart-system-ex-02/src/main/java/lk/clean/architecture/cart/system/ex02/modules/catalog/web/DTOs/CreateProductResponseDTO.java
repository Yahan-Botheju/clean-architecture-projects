package lk.clean.architecture.cart.system.ex02.modules.catalog.web.DTOs;

import lk.clean.architecture.cart.system.ex02.modules.catalog.domain.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductResponseDTO {
    private UUID productId;
    private String productName;
    private double unitPrice;
    private int stockQuantity;
    private ProductStatus productStatus;
}
