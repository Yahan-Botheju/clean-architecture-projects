package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.api.CustomerCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.api.CustomerStatusCheckApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.enums.DeliveryStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.models.Delivery;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.domain.repositories.DeliveryRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CreateDeliveryCommand;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CreateDeliveryResult;
import lk.clean.architecture.drone.delivery.mission.control.api.shared_domain.customer.CustomerCheckApiDTO;

import java.time.LocalDateTime;
import java.util.UUID;

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

    //check pickup locations are available
    private void checkLocation(String pickupLocation, String deliveryLocation) {
        if(pickupLocation == null || pickupLocation.isBlank() ||
                 deliveryLocation == null || deliveryLocation.isBlank()){
            throw new IllegalArgumentException("Locations cannot be empty");
        }
    }

    /* __PUBLIC_METHODS_ */


    //create delivery
    @Override
    public CreateDeliveryResult createDelivery(CreateDeliveryCommand createDeliveryCommand) {

        //check customer existence

        CustomerCheckApiDTO customer = customerCheckApi.getCustomerCheck(createDeliveryCommand.customerId());
        //check customer status is active
        customerStatusCheckApi.checkCustomerStatus(customer.customerId());

        //check package weight is more than 0
        checkPackageWeight(createDeliveryCommand.packageWeightKg());
        //check pickup location
        checkLocation(createDeliveryCommand.deliveryLocation(), createDeliveryCommand.deliveryLocation());

        //create order id and current time
        UUID orderId = UUID.randomUUID();
        LocalDateTime requestedAt = LocalDateTime.now();

        //create new model
        Delivery newDelivery = new Delivery(
                orderId,
                customer.customerId(),
                null,
                createDeliveryCommand.packageWeightKg(),
                createDeliveryCommand.pickupLocation(),
                createDeliveryCommand.deliveryLocation(),
                DeliveryStatus.REQUESTED,
                requestedAt,
                null,
                null,
                null,
                null
        );

        //save delivery
        deliveryRepository.save(newDelivery);


        return new CreateDeliveryResult(
                newDelivery.getDeliveryId(),
                newDelivery.getCustomerId(),
                newDelivery.getAssignedDroneId(),
                newDelivery.getPackageWeightKg(),
                newDelivery.getPickupLocation(),
                newDelivery.getDeliveryLocation(),
                newDelivery.getDeliveryStatus(),
                newDelivery.getRequestedAt(),
                newDelivery.getScheduledAt(),
                newDelivery.getCompletedAt(),
                newDelivery.getFailedAt(),
                newDelivery.getCancelledAt()
        );
    }


}
