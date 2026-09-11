package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CancelDeliveryResult;

import java.util.UUID;

public interface CancelDeliveryUseCase {

    //cancel delivery
    CancelDeliveryResult cancelDelivery(UUID deliveryId); /* __#11 COMMIT -> initiate method__   CancelDeliveryUseCase.java */
}
