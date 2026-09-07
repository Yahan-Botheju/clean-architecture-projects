package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;

public class StartMissionUseCaseImpl implements StartMissionUseCase {

    //inject required dependencies
    private final DeliveryRepository deliveryRepository;

    public StartMissionUseCaseImpl(DeliveryRepository deliveryRepository) {
        this.deliveryRepository=deliveryRepository;
    }
}
