package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.api.CustomerCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CreateDeliveryCommand;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CreateDeliveryResult;

public class CreateDeliveryUseCaseImpl implements CreateDeliveryUseCase {

    //inject required dependencies
    private final DeliveryRepository deliveryRepository;
    private final CustomerCheckApi customerCheckApi;

    public CreateDeliveryUseCaseImpl(
            DeliveryRepository deliveryRepository,
            CustomerCheckApi customerCheckApi
            ) {
        this.deliveryRepository = deliveryRepository;
        this.customerCheckApi = customerCheckApi;
    }

    //create delivery
    @Override
    public CreateDeliveryResult createDelivery(CreateDeliveryCommand createDeliveryCommand) {

        //check customer existence


        return null;
    }
}
