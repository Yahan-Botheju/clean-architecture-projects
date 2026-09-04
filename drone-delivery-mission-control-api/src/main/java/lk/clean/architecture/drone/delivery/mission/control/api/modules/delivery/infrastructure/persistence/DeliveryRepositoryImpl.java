package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.persistence;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.persistence.jpa.JpaDeliveryRepository;

public class DeliveryRepositoryImpl implements DeliveryRepository {

    //inject required dependencies
    private final DeliveryRepository deliveryRepository;
    private final JpaDeliveryRepository jpaDeliveryRepository;

    public DeliveryRepositoryImpl(
            DeliveryRepository deliveryRepository,
            JpaDeliveryRepository jpaDeliveryRepository
    ) {
        this.deliveryRepository = deliveryRepository;
        this.jpaDeliveryRepository = jpaDeliveryRepository;
    }
}
