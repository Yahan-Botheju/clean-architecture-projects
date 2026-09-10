package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.FailedMissionCommand;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.FailedMissionResult;


public interface FailedMissionUseCase {

    //mission failed
    FailedMissionResult failedMission(FailedMissionCommand failedMissionCommand);
}
