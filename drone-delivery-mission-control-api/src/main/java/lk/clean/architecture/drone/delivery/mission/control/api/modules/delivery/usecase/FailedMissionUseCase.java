package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.enums.FailureReasonStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.FailedMissionResult;

import java.util.UUID;

public interface FailedMissionUseCase {

    //mission failed
    FailedMissionResult failedMission(UUID deliveryId, FailureReasonStatus failureReason);
}
