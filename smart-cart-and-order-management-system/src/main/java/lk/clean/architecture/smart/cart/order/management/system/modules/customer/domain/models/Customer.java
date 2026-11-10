package lk.clean.architecture.smart.cart.order.management.system.modules.customer.domain.models;

import lk.clean.architecture.smart.cart.order.management.system.modules.customer.domain.enums.CustomerStatus;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class Customer {
    private final UUID customerId;
    private String fullName;
    private String email;
    private CustomerStatus customerStatus;
    private LocalDateTime createdAt;

    public Customer(UUID customerId, String fullName, String email, CustomerStatus customerStatus, LocalDateTime createdAt) {
        this.customerId = customerId;
        this.fullName = fullName;
        this.email = email;
        this.customerStatus = customerStatus;
        this.createdAt = createdAt;
    }


    /* __FACTORY_METHOD_FOR_CUSTOMER_CREATEION__*/

    public static Customer createNewCustomer(String fullName, String email, CustomerStatus customerStatus, LocalDateTime createdAt) {
        return new Customer(
                UUID.randomUUID(),
                fullName,
                email,
                customerStatus,
                createdAt
        );
    }


    /* __DOMAIN_LOGIC__ */


    //suspended customer
    public void suspendedCustomer(){
        if(customerStatus == CustomerStatus.SUSPENDED){
            throw new IllegalStateException("Suspended Customer cannot process the operation");
        }
    }

    //active suspended customer
    public void activeCustomer(){
        if(customerStatus != CustomerStatus.SUSPENDED){
            throw new IllegalStateException("Customer is not in correct state to continue the process");
        }
        //mutate the event
        this.customerStatus = CustomerStatus.ACTIVE;
    }
}
