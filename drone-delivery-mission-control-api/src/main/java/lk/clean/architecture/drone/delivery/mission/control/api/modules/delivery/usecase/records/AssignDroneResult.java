package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.enums.DeliveryStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record AssignDroneResult(
        UUID deliveryId,
        UUID customerId,
        UUID assignedDroneId,
        double packageWeightKg,
        String pickupLocation,
        String deliveryLocation,
        DeliveryStatus deliveryStatus,
        LocalDateTime requestedAt,
        LocalDateTime scheduledAt,
        LocalDateTime completedAt,
        LocalDateTime failedAt,
        LocalDateTime cancelledAt
) {
}
