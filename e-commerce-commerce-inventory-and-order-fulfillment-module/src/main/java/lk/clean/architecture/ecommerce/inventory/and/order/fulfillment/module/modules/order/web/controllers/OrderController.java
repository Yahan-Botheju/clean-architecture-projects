package lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.web.controllers;

import jakarta.validation.Valid;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.domain.modules.Order;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.usecase.ConfirmOrderUseCase;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.usecase.PlaceOrderUseCase;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.usecase.ShipOrderUseCase;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.web.DTOs.OrderResponseDTO;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.web.DTOs.PlaceOrderRequestDTO;
import lk.clean.architecture.ecommerce.inventory.and.order.fulfillment.module.modules.order.web.webMappers.OrderWebMapper;
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

    //place order
    @PostMapping
    public ResponseEntity<OrderResponseDTO> placeOrder(
            @Valid @RequestBody PlaceOrderRequestDTO placeOrderRequestDTO
    ){
        //set values to usecase
        Order toUseCase = placeOrderUseCase.placeOrder(
                placeOrderRequestDTO.getCustomerId(),
                placeOrderRequestDTO.getProductId(),
                placeOrderRequestDTO.getRequestQuantity()
        );

        OrderResponseDTO responseDTO = orderWebMapper.toResponseDTO(toUseCase);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
