package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.infrastructure.persistence.entities;

import jakarta.persistence.*;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.enums.DroneStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "drones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DroneEntity {

    @Id
    @Column(name = "drone_id", nullable = false)
    private UUID droneId;

    @Column(name = "serial_number", nullable = false, unique = true)
    private String serialNumber;

    @Column(name = "serial_number", nullable = false)
    @Enumerated(EnumType.STRING)
    private DroneStatus droneStatus;

    @Column(name = "max_payloadingKg")
    private double maxPayloadingKg;

    @Column(name = "battery_percentage", nullable = false)
    private double batteryPercentage;
}
