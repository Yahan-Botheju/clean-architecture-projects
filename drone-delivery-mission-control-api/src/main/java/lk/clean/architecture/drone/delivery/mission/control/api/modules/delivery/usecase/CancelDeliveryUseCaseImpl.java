package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;

public class CancelDeliveryUseCaseImpl implements CancelDeliveryUseCase {

    //inject required dependencies
    private final DeliveryRepository deliveryRepository;

    public CancelDeliveryUseCaseImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }
}
