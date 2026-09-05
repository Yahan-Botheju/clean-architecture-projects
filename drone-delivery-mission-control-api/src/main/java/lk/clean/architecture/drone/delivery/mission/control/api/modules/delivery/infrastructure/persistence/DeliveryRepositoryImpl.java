package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.persistence;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.models.Delivery;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.persistence.entities.DeliveryEntity;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.persistence.jpa.JpaDeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.persistence.persistenceMappers.DeliveryPersistenceMapper;

import java.util.Optional;
import java.util.UUID;

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

    //check delivery existence
    @Override
    public Optional<Delivery> getDeliveryById(UUID deliveryId){
        return jpaDeliveryRepository.findByDeliveryId(deliveryId)
                .map(deliveryPersistenceMapper::toDomainModel);
    }

    //save delivery
    @Override
    public Delivery save(Delivery delivery) {
        DeliveryEntity toEntity = deliveryPersistenceMapper.toEntity(delivery);
        DeliveryEntity savedEntity = jpaDeliveryRepository.save(toEntity);

        return deliveryPersistenceMapper.toDomainModel(savedEntity);
    }
}
