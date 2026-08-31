package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.enums.DeliveryStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "deliveries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryEntity {

    @Id
    @Column(name = "delivery_id", nullable = false)
    private UUID deliveryId;

    @Column(name = "customer_id", nullable = false)
    private UUID customerId;

    @Column(name = "drone_id", nullable = false)
    private UUID assignedDroneId;

    @Column(name = "package_weight")
    private double packageWeightKg;

    @Column(name = "pickup_location")
    private String pickupLocation;

    @Column(name = "delivery_location")
    private String deliveryLocation;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery_status")
    private DeliveryStatus deliveryStatus;

    @Column(name = "requested_at")
    private LocalDateTime requestedAt;

    @Column(name = "scheduled_at")
    private LocalDateTime scheduledAt;
}
