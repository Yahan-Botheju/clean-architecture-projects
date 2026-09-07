package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import java.util.UUID;

public interface StartMissionUseCase {

    //start mission
    void startMission(UUID deliveryId);
}
