package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.models;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.enums.DeliveryStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class Delivery {
    private final UUID deliveryId;
    private final UUID customerId;
    private final UUID assignedDroneId;
    private double packageWeightKg;
    private String pickupLocation;
    private String deliveryLocation;
    private DeliveryStatus deliveryStatus;
    private LocalDateTime requestedAt;
    private LocalDateTime scheduledAt;

    public Delivery(
            LocalDateTime scheduledAt,
            LocalDateTime requestedAt,
            DeliveryStatus deliveryStatus,
            String deliveryLocation,
            String pickupLocation,
            double packageWeightKg,
            UUID assignedDroneId,
            UUID customerId,
            UUID deliveryId
    ) {
        this.scheduledAt = scheduledAt;
        this.requestedAt = requestedAt;
        this.deliveryStatus = deliveryStatus;
        this.deliveryLocation = deliveryLocation;
        this.pickupLocation = pickupLocation;
        this.packageWeightKg = packageWeightKg;
        this.assignedDroneId = assignedDroneId;
        this.customerId = customerId;
        this.deliveryId = deliveryId;
    }

    public UUID getDeliveryId() { return deliveryId; }
    public UUID getCustomerId() { return customerId; }
    public UUID getAssignedDroneId() { return assignedDroneId; }
    public double getPackageWeightKg() { return packageWeightKg; }
    public String getPickupLocation() { return pickupLocation; }
    public String getDeliveryLocation() { return deliveryLocation; }
    public DeliveryStatus getDeliveryStatus() { return deliveryStatus; }
    public LocalDateTime getRequestedAt() { return requestedAt; }
    public LocalDateTime getScheduledAt() { return scheduledAt; }

}
