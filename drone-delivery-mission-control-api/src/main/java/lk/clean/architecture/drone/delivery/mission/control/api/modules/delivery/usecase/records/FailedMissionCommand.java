package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.enums.FailureReasonStatus;

public record FailedMissionCommand(
        FailureReasonStatus failureReasonStatus
) {}
