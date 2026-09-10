package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;

public class FailedMissionUseCaseImpl implements FailedMissionUseCase{

    //inject required dependencies
    private final DeliveryRepository  deliveryRepository;

    public FailedMissionUseCaseImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }
}
