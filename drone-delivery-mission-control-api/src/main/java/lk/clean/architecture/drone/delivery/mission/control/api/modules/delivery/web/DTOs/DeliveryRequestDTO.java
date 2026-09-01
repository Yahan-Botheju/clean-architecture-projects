package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryRequestDTO {
    @NotNull(message = "Customer ID cannot be empty")
    private UUID customerId;

    @NotNull(message = "Package weight cannot be empty")
    private double packageWeightKg;

    @NotBlank(message = "Pick up location cannot be empty")
    private String pickupLocation;

    @NotBlank(message = "Delivery location cannot be empty")
    private String deliveryLocation;
}
