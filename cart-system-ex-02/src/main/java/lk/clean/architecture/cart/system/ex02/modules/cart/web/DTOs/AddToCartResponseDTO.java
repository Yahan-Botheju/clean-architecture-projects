package lk.clean.architecture.cart.system.ex02.modules.cart.web.DTOs;

import lk.clean.architecture.cart.system.ex02.modules.cart.domain.models.CartItem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddToCartResponseDTO {
    private UUID cartId;
    private UUID userId;
    private List<CartItem> cartItems;
    private double totalPrice;
}
