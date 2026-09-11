package lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.enums.DroneStatus;

import java.util.UUID;

public record DroneStatusApiDTO(
        UUID droneId,
        String serialNumber,
        DroneStatus droneStatus,
        double maxPayloadingKg,
        double batteryPercentage
) {
}
/* __#6 COMMIT -> create new record class __ DroneStatusApiDTO.java */