package lk.clean.architecture.smart.cart.order.management.system.modules.product.web.DTOs;

import lk.clean.architecture.smart.cart.order.management.system.modules.product.domain.enums.ProductStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeProductPriceResponseDTO {
    private UUID productId;
    private String sku;
    private String productName;
    private String productDescription;
    private BigDecimal productPrice;
    private ProductStatus productStatus;
    private LocalDateTime createdAt;
}
