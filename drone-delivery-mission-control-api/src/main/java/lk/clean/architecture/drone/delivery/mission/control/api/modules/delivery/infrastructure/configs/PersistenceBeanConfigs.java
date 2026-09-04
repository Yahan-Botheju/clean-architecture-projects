package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.configs;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.persistence.DeliveryRepositoryImpl;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.persistence.jpa.JpaDeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.infrastructure.persistence.persistenceMappers.DeliveryPersistenceMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceBeanConfigs {

    //delivery persistence impl
    @Bean
    public DeliveryRepository deliveryRepository(
            JpaDeliveryRepository jpaDeliveryRepository,
            DeliveryPersistenceMapper deliveryPersistenceMapper
    ) {
        return new DeliveryRepositoryImpl(jpaDeliveryRepository, deliveryPersistenceMapper);
    }
}
