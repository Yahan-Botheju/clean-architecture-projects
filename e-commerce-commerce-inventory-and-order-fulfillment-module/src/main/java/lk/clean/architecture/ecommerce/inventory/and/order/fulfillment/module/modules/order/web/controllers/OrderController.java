package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.web.controllers;

import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.usecase.ConfirmOrderUseCase;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.usecase.PlaceOrderUseCase;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.usecase.ShipOrderUseCase;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.web.webMappers.OrderWebMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    //inject required dependencies
    private final PlaceOrderUseCase placeOrderUseCase;
    private final ConfirmOrderUseCase confirmOrderUseCase;
    private final ShipOrderUseCase shipOrderUseCase;
    private final OrderWebMapper orderWebMapper;

    public OrderController(
            PlaceOrderUseCase placeOrderUseCase,
            ConfirmOrderUseCase confirmOrderUseCase,
            ShipOrderUseCase shipOrderUseCase,
            OrderWebMapper orderWebMapper
    ) {
        this.placeOrderUseCase = placeOrderUseCase;
        this.confirmOrderUseCase = confirmOrderUseCase;
        this.shipOrderUseCase = shipOrderUseCase;
        this.orderWebMapper = orderWebMapper;
    }
}
