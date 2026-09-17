package lk.clean.architecture.cart.system.ex02.modules.order.web.controllers;

import lk.clean.architecture.cart.system.ex02.modules.order.usecase.GetOrderDetailsUseCase;
import lk.clean.architecture.cart.system.ex02.modules.order.usecase.PlaceOrderUseCase;
import lk.clean.architecture.cart.system.ex02.modules.order.web.webMapper.OrderWebMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    //inject required dependencies
    private final PlaceOrderUseCase placeOrderUseCase;
    private final GetOrderDetailsUseCase getOrderDetailsUseCase;
    private final OrderWebMapper orderWebMapper;

    public OrderController(
            PlaceOrderUseCase placeOrderUseCase,
            GetOrderDetailsUseCase getOrderDetailsUseCase,
            OrderWebMapper orderWebMapper
    ) {
        this.placeOrderUseCase = placeOrderUseCase;
        this.getOrderDetailsUseCase = getOrderDetailsUseCase;
        this.orderWebMapper = orderWebMapper;
    }
}
