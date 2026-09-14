package lk.clean.architecture.cart.system.ex02.modules.cart.web.DTOs;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCartItemRequestDTO {

    @NotNull(message = "User ID cannot be empty")
    private UUID userId;

    @NotNull(message = "Product ID cannot be empty")
    private UUID productId;

    @NotNull(message = "Request quantity cannot be empty")
    private int newQuantity;
}
