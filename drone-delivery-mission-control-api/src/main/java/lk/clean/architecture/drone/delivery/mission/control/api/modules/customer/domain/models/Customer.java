package lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.domain.models;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.customer.domain.enums.CustomerStatus;

import java.util.UUID;

public class Customer {
    private final UUID customerId;
    private String customerName;
    private String customerEmail;
    private CustomerStatus customerStatus;

    public Customer(UUID customerId, String customerName, String customerEmail, CustomerStatus customerStatus) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerStatus = customerStatus;
    }

    public UUID getCustomerId() { return customerId; }
    public String getCustomerName() { return customerName; }
    public String getCustomerEmail() { return customerEmail; }
    public CustomerStatus getCustomerStatus() { return customerStatus; }


    /* __DOMAIN_LOGICS__ */

    //check customer suspendable
    public void deliveryRequest(){
        if(this.customerStatus == CustomerStatus.SUSPENDED){
            throw new IllegalStateException("Customer is suspended");
        }
    }

    //check customer status is active
    public boolean isActive(){
        return this.customerStatus == CustomerStatus.ACTIVE;
    }

}
