package lk.clean.architecture.cart.system.ex02.modules.order.web.DTOs;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceOrderRequestDTO {

    @NotNull(message = "User ID cannot be empty")
    private UUID userId;
}
