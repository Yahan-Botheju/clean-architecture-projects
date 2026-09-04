package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.persistence;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.persistence.jpa.JpaDeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.persistence.persistenceMappers.DeliveryPersistenceMapper;

public class DeliveryRepositoryImpl implements DeliveryRepository {

    //inject required dependencies
    private final JpaDeliveryRepository jpaDeliveryRepository;
    private final DeliveryPersistenceMapper deliveryPersistenceMapper;

    public DeliveryRepositoryImpl(
           JpaDeliveryRepository jpaDeliveryRepository,
           DeliveryPersistenceMapper deliveryPersistenceMapper
    ) {
        this.jpaDeliveryRepository = jpaDeliveryRepository;
        this.deliveryPersistenceMapper = deliveryPersistenceMapper;
    }
}
