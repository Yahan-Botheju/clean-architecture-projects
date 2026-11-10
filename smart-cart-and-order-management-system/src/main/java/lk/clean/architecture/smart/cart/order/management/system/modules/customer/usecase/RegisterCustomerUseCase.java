package lk.clean.architecture.smart.cart.order.management.system.modules.customer.usecase;

import lk.clean.architecture.smart.cart.order.management.system.modules.customer.usecase.records.CustomerRegisterCommand;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.usecase.records.CustomerRegisterResult;

public interface RegisterCustomerUseCase {

    //register new customer
    CustomerRegisterResult registerCustomer(CustomerRegisterCommand customerRegisterCommand);
}
