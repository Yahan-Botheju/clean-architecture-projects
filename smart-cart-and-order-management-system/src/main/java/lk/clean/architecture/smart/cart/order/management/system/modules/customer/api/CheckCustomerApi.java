package lk.clean.architecture.smart.cart.order.management.system.modules.customer.api;

import lk.clean.architecture.smart.cart.order.management.system.shared_domain.customer_shared_api.CheckCustomerApiResult;

import java.util.UUID;

public interface CheckCustomerApi {

    //check customer by customer id
    CheckCustomerApiResult checkCustomerByCustomerId(UUID customerId);
}
