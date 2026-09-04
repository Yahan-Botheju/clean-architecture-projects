package lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.api;

import java.util.UUID;

public interface CustomerStatusCheckApi {

    public boolean checkCustomerStatus(UUID customerId);
}
