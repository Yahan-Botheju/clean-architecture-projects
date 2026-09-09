package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CompleteMissionResult;

import java.util.UUID;

public interface CompleteMissionUseCase {

    CompleteMissionResult completeMission(UUID deliveryId);
}
