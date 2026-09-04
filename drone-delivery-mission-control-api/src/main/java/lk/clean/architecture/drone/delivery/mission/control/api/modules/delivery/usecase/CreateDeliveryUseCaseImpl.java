package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.api.CustomerCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.api.CustomerStatusCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CreateDeliveryCommand;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CreateDeliveryResult;

public class CreateDeliveryUseCaseImpl implements CreateDeliveryUseCase {

    //inject required dependencies
    private final DeliveryRepository deliveryRepository;
    private final CustomerCheckApi customerCheckApi;
    private final CustomerStatusCheckApi customerStatusCheckApi;

    public CreateDeliveryUseCaseImpl(
            DeliveryRepository deliveryRepository,
            CustomerCheckApi customerCheckApi,
            CustomerStatusCheckApi customerStatusCheckApi
    ) {
        this.deliveryRepository = deliveryRepository;
        this.customerCheckApi = customerCheckApi;
        this.customerStatusCheckApi = customerStatusCheckApi;
    }

    //create delivery
    @Override
    public CreateDeliveryResult createDelivery(CreateDeliveryCommand createDeliveryCommand) {

        //check customer existence
        customerCheckApi.getCustomerCheck(createDeliveryCommand.customerId());
        //check customer status is active
        customerStatusCheckApi.checkCustomerStatus(createDeliveryCommand.customerId());

        //check package weight is more than 0
        if(!checkPackageWeight(createDeliveryCommand.packageWeightKg())){
            throw new IllegalStateException("package weight must be greater than zero.");
        }

        return null;
    }

    //check package weight
    private boolean checkPackageWeight(double packageWeightKg) {
        return packageWeightKg > 0;
    }
}
