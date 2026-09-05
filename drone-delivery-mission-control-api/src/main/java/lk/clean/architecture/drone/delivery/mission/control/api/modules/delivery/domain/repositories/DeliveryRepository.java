package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.models.Delivery;

import java.util.Optional;
import java.util.UUID;

public interface DeliveryRepository {

    //check delivery existence
    Optional<Delivery> getDeliveryById(UUID deliveryId);


    //save new delivery
    Delivery save(Delivery delivery);
}
