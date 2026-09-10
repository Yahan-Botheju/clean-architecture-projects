package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.models;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.enums.DeliveryStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public class Delivery {
    private final UUID deliveryId;
    private final UUID customerId;
    private UUID assignedDroneId;
    private double packageWeightKg;
    private String pickupLocation;
    private String deliveryLocation;
    private DeliveryStatus deliveryStatus;
    private LocalDateTime requestedAt;
    private LocalDateTime scheduledAt;
    private LocalDateTime startedAt;
    private LocalDateTime completedAt;
    private LocalDateTime failedAt;
    private LocalDateTime cancelledAt;

    public Delivery(
            UUID deliveryId, UUID customerId, UUID assignedDroneId,
            double packageWeightKg, String pickupLocation, String deliveryLocation,
            DeliveryStatus deliveryStatus, LocalDateTime requestedAt,
            LocalDateTime scheduledAt,LocalDateTime startedAt ,LocalDateTime completedAt, LocalDateTime failedAt, LocalDateTime cancelledAt
    ) {
        this.deliveryId = deliveryId;
        this.customerId = customerId;
        this.assignedDroneId = assignedDroneId;
        this.packageWeightKg = packageWeightKg;
        this.pickupLocation = pickupLocation;
        this.deliveryLocation = deliveryLocation;
        this.deliveryStatus = deliveryStatus;
        this.requestedAt = requestedAt;
        this.scheduledAt = scheduledAt;
        this.startedAt = startedAt;
        this.completedAt = completedAt;
        this.failedAt = failedAt;
        this.cancelledAt = cancelledAt;
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
    public LocalDateTime getStartedAt() { return startedAt; }
    public LocalDateTime getCompletedAt() { return completedAt; }
    public LocalDateTime getFailedAt() { return failedAt; }
    public LocalDateTime getCancelledAt() { return cancelledAt; }


    /* __DOMAIN_LOGIC__ */

    /*
     *
     * REQUESTED -> CANCEL || SCHEDULE
     * SCHEDULE -> CANCEL || IN_PROGRESS
     * IN_PROGRESS ->  DELIVERY || FAILED
     *
     * */

    //assign a drone for delivery
    public void assignDelivery(UUID droneId, LocalDateTime requestedTime) {
        //check incoming id is null
        if (droneId == null) {
            throw new IllegalStateException("Drone ID cannot be null");
        }
        //check allocation variable in null
        if (this.assignedDroneId != null) {
            throw new IllegalStateException("assignedDroneId is already active");
        }
        //mutate the state
        this.assignedDroneId = droneId;
        this.deliveryStatus = DeliveryStatus.SCHEDULED;
        this.requestedAt = requestedTime;
    }

    //schedule the drone
    public void scheduleDelivery(LocalDateTime scheduledTime) {
        if (this.deliveryStatus != DeliveryStatus.REQUESTED) {
            throw new IllegalStateException("Drone is not in requested state, unable to schedule");
        }
        this.deliveryStatus = DeliveryStatus.SCHEDULED;
        this.scheduledAt = scheduledTime;
    }

    //set drone to in progress
    public void inProgressDelivery(LocalDateTime startingTime) {
        if (this.deliveryStatus != DeliveryStatus.SCHEDULED) {
            throw new IllegalStateException("Drone is not in requested state, unable to inprogress");
        }
        this.deliveryStatus = DeliveryStatus.IN_PROGRESS;
        this.startedAt = startingTime;
    }

    //delivered by drone
    public void deliveredDelivery(LocalDateTime deliveredTime) {
        if (this.deliveryStatus != DeliveryStatus.IN_PROGRESS) {
            throw new IllegalStateException("Drone is not in requested state, unable to deliver");
        }
        this.deliveryStatus = DeliveryStatus.DELIVERED;
        this.completedAt = deliveredTime;
    }

    public void deliveryFailedDelivery(LocalDateTime failedTime) {
        if (this.deliveryStatus != DeliveryStatus.IN_PROGRESS) {
            throw new IllegalStateException("Drone is not in requested state");
        }
        this.deliveryStatus = DeliveryStatus.FAILED;
        this.failedAt = failedTime;
    }

    //cancel the drone
    public void cancelDelivery(LocalDateTime cancelledTime) {
        if (this.deliveryStatus != DeliveryStatus.REQUESTED && this.deliveryStatus != DeliveryStatus.SCHEDULED) {
            throw new IllegalStateException("Drone is not in requested state, unable to cancel");
        }
        this.deliveryStatus = DeliveryStatus.CANCELLED;
        this.cancelledAt = cancelledTime;
    }


    /* __FACTORY_METHOD__ */

    //create new delivery model
    public static Delivery createNewDelivery(
            UUID orderId, UUID customerId, UUID assignedDroneId, double packageWeightKg,
            String pickupLocation, String deliveryLocation, DeliveryStatus deliveryStatus,
            LocalDateTime requestedAt, LocalDateTime scheduledAt, LocalDateTime startedAt, LocalDateTime completedAt,
            LocalDateTime failedAt, LocalDateTime cancelledAt
    ) {
        return new Delivery(
                orderId,
                customerId,
                assignedDroneId,
                packageWeightKg,
                pickupLocation,
                deliveryLocation,
                deliveryStatus,
                null,
                null,
                null,
                null,
                null,
                null
        );
    }
}
