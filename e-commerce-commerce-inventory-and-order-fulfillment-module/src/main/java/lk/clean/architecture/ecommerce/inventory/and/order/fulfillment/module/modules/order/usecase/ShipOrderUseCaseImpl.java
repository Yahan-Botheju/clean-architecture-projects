package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.usecase;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.api.InventoryModuleApi;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.modules.Order;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.repositories.OrderRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import java.time.LocalDateTime;
import java.util.UUID;

public class ShipOrderUseCaseImpl implements ShipOrderUseCase {

    //inject required dependencies
    private final OrderRepository orderRepository;
    private final InventoryModuleApi inventoryModuleApi;

    public ShipOrderUseCaseImpl(
            OrderRepository orderRepository,
            InventoryModuleApi inventoryModuleApi
    ) {
        this.orderRepository = orderRepository;
        this.inventoryModuleApi = inventoryModuleApi;
    }

    //ship order
    @Override
    public Order shipOrder(UUID orderId){
        //check order
        Order chcekOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order Not Found"));

        //use domain logic
        LocalDateTime currentTime = LocalDateTime.now();
        chcekOrder.shipCheck(currentTime);

        //use inventory domain for product existence
        inventoryModuleApi.deductStock(
                chcekOrder.getProductId(),
                chcekOrder.getOrderQuantity(),
                currentTime
        );

        //save order
        return orderRepository.save(chcekOrder);
    }
}
