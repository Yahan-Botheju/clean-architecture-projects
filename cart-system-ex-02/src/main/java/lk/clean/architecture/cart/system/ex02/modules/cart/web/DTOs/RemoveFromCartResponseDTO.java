package lk.clean.architecture.cart.system.ex02.modules.cart.web.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RemoveFromCartResponseDTO {
    private UUID productId;
    private String productName;
    private double unitPrice;
    private UUID cartId;
    private UUID userId;
}
