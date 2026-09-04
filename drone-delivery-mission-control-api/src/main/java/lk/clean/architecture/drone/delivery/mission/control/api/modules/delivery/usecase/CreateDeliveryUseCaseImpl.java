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

    /* __HELPER_METHODS_ */


    //check package weight
    private void checkPackageWeight(double packageWeightKg) {
        if(packageWeightKg < 0.0) {
            throw new IllegalArgumentException("package weight must be greater than 0");
        }
    }

    private void checkLocation(String pickupLocation, String deliveryLocation) {
        if(pickupLocation == null || deliveryLocation == null){
            throw new IllegalArgumentException("Locations cannot be empty");
        }
    }

    /* __PUBLIC_METHODS_ */


    //create delivery
    @Override
    public CreateDeliveryResult createDelivery(CreateDeliveryCommand createDeliveryCommand) {

        //check customer existence
        customerCheckApi.getCustomerCheck(createDeliveryCommand.customerId());
        //check customer status is active
        customerStatusCheckApi.checkCustomerStatus(createDeliveryCommand.customerId());

        //check package weight is more than 0


        checkLocation(createDeliveryCommand.deliveryLocation(), createDeliveryCommand.deliveryLocation());

        return null;
    }




}
