package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.web.DTOs;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaceOrderRequestDTO {

    @NotNull(message = "Customer Id cannot be empty")
    private UUID customerId;

    @NotNull(message = "Product Id cannot be empty")
    private UUID productId;

    @NotNull(message = "Requested quantity cannot be empty")
    @Min(1)
    private int requestQuantity;
}
