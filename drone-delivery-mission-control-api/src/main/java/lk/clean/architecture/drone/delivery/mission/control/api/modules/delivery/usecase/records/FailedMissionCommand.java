package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.enums.FailureReasonStatus;

import java.util.UUID;

public record FailedMissionCommand(
        UUID deliveryId,
        FailureReasonStatus failureReasonStatus
) {}
