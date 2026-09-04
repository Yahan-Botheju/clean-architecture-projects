package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.models.Delivery;

public interface DeliveryRepository {

    //save new delivery
    Delivery save(Delivery delivery);
}
