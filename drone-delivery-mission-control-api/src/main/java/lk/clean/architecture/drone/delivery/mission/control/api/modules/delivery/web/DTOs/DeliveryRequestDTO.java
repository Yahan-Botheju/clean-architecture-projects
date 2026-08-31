package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryRequestDTO {
    private UUID customerId;
    private double packageWeightKg;
    private String pickupLocation;
    private String deliveryLocation;
}
