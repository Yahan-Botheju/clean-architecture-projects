package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CreateDeliveryCommand;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CreateDeliveryResult;

public interface CreateDeliveryUseCase {

    //create a delivery
    CreateDeliveryResult createDelivery(CreateDeliveryCommand createDeliveryCommand);
}
