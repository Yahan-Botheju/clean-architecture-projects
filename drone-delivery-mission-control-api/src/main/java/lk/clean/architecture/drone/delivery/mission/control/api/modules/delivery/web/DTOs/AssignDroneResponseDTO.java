package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.enums.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignDroneResponseDTO {
    private UUID deliveryId;
    private UUID customerId;
    private UUID assignedDroneId;
    private double packageWeightKg;
    private String pickupLocation;
    private String deliveryLocation;
    private DeliveryStatus deliveryStatus;
    private LocalDateTime requestedAt;
    private LocalDateTime scheduledAt;
    private LocalDateTime completedAt;
    private LocalDateTime failedAt;
    private LocalDateTime cancelledAt;
}
