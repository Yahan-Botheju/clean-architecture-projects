package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.usecase;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.api.InventoryModuleApi;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.modules.Order;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.repositories.OrderRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.math.BigDecimal;
import java.util.UUID;

public class PlaceOrderUseCaseImpl implements PlaceOrderUseCase{

    //inject required dependencies
    private final OrderRepository orderRepository;
    private final InventoryModuleApi inventoryModuleApi;

    public PlaceOrderUseCaseImpl(
            OrderRepository orderRepository,
            InventoryModuleApi inventoryModuleApi
    ) {
        this.orderRepository = orderRepository;
        this.inventoryModuleApi = inventoryModuleApi;
    }

    public Order placeOrder(
            UUID customerId,
            UUID productId,
            int requestQuantity
    ){

        //check product existence
        Order checkProduct = orderRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("product not found"));

        if(!orderRepository.customer_existsById(customerId)){
            throw new ResourceNotFoundException("customer not found");
        }

    return null;
    }
}
