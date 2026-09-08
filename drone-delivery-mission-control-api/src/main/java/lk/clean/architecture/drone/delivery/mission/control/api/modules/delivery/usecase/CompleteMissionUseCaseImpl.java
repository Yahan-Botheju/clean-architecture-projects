package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;

public class CompleteMissionUseCaseImpl implements CompleteMissionUseCase {

    //inject required dependencies
    private final DeliveryRepository deliveryRepository;

    public CompleteMissionUseCaseImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }
}
