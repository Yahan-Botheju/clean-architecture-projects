package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records;

import java.util.UUID;

public record AssignDroneCommand(
        UUID droneId
) {}
