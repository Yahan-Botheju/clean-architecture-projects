package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.StartMissionResult;

import java.util.UUID;

public interface StartMissionUseCase {

    //start mission
    StartMissionResult startMission(UUID deliveryId);
}
