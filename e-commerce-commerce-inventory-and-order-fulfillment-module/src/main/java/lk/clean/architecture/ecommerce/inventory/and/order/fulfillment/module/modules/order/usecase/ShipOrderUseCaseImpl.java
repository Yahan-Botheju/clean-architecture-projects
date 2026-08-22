package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.usecase;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.api.InventoryModuleApi;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.inventoryItem.domain.repositories.InventoryItemRepository;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.modules.Order;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.repositories.OrderRepository;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

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

    public Order shipOrder(UUID orderId) {

        Order chcekOrder = orderRepository.findById(orderId)
                .orElseThrow(() -> new ResourceNotFoundException("Order Not Found"));


    }
}
