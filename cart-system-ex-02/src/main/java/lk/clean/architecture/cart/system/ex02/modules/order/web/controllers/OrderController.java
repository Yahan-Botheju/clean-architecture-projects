package lk.clean.architecture.cart.system.ex02.modules.order.web.controllers;

import jakarta.validation.Valid;
import lk.clean.architecture.cart.system.ex02.modules.order.usecase.GetOrderDetailsUseCase;
import lk.clean.architecture.cart.system.ex02.modules.order.usecase.PlaceOrderUseCase;
import lk.clean.architecture.cart.system.ex02.modules.order.usecase.records.PlaceOrderCommand;
import lk.clean.architecture.cart.system.ex02.modules.order.usecase.records.PlaceOrderResult;
import lk.clean.architecture.cart.system.ex02.modules.order.web.DTOs.PlaceOrderRequestDTO;
import lk.clean.architecture.cart.system.ex02.modules.order.web.DTOs.PlaceOrderResponseDTO;
import lk.clean.architecture.cart.system.ex02.modules.order.web.webMapper.OrderWebMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    //check out an order
    @PostMapping("/checkout")
    public ResponseEntity<PlaceOrderResponseDTO> checkout(
            @Valid @RequestBody PlaceOrderRequestDTO placeOrderRequestDTO
    ){
        PlaceOrderCommand toCommand = orderWebMapper.toPlaceOrderCommand(placeOrderRequestDTO);
        PlaceOrderResult toUseCase =  placeOrderUseCase.execute(toCommand);
        PlaceOrderResponseDTO responseDTO = orderWebMapper.toPlaceOrderResponseDTO(toUseCase);

        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }
}
