package lk.clean.architecture.ecommerce.order.processing.module.web.controller;

import jakarta.validation.Valid;
import lk.clean.architecture.ecommerce.order.processing.module.domain.modules.Order;
import lk.clean.architecture.ecommerce.order.processing.module.usecase.order.ConfirmOrderUseCase;
import lk.clean.architecture.ecommerce.order.processing.module.usecase.order.CreateOrderUseCase;
import lk.clean.architecture.ecommerce.order.processing.module.web.DTOs.OrderRequestDTO;
import lk.clean.architecture.ecommerce.order.processing.module.web.DTOs.OrderResponseDTO;
import lk.clean.architecture.ecommerce.order.processing.module.web.webMappers.OrderWebMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    //inject required dependencies
    private final ConfirmOrderUseCase confirmOrderUseCase;
    private final CreateOrderUseCase createOrderUseCase;
    private final OrderWebMapper orderWebMapper;

    public OrderController(
            ConfirmOrderUseCase confirmOrderUseCase,
            CreateOrderUseCase createOrderUseCase,
            OrderWebMapper orderWebMapper
    ) {
        this.confirmOrderUseCase = confirmOrderUseCase;
        this.createOrderUseCase = createOrderUseCase;
        this.orderWebMapper = orderWebMapper;
    }

    //create new order
    @PostMapping
    public ResponseEntity<OrderResponseDTO> placeOrder(
            @Valid @RequestBody OrderRequestDTO orderRequestDTO
    ) {
         Order createOrder = createOrderUseCase.createOrder(
                 orderRequestDTO.getCustomerId(),
                 orderRequestDTO.getTotalAmount(),
                 orderRequestDTO.getShippingAddress());

         OrderResponseDTO orderResponseDTO = orderWebMapper.toResponseDTO(createOrder);

         return ResponseEntity.status(HttpStatus.CREATED).body(orderResponseDTO);
    }

    //placed order
    @PatchMapping("/{orderId}/confirm")
    public ResponseEntity<OrderResponseDTO> confirmOrder(
            @PathVariable UUID OrderId
    ){
        Order placedOrder = confirmOrderUseCase.confirmOrder(OrderId);
        OrderResponseDTO orderResponseDTO = orderWebMapper.toResponseDTO(placedOrder);

        return ResponseEntity.status(HttpStatus.OK).body(orderResponseDTO);
    }
}
