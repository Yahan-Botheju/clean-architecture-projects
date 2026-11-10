package lk.clean.architecture.smart.cart.order.management.system.modules.customer.web.controllers;

import jakarta.validation.Valid;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.usecase.RegisterCustomerUseCase;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.usecase.records.CustomerRegisterCommand;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.usecase.records.CustomerRegisterResult;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.web.DTOs.CustomerRegisterRequestDTO;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.web.DTOs.CustomerRegisterResponseDTO;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.web.webMapper.RegisterCustomerWebMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cusomters")
public class CustomerController {

    //inject required dependencies
    private final RegisterCustomerUseCase registerCustomerUseCase;
    private final RegisterCustomerWebMapper registerCustomerWebMapper;

    public CustomerController(RegisterCustomerUseCase registerCustomerUseCase, RegisterCustomerWebMapper registerCustomerWebMapper) {
        this.registerCustomerUseCase = registerCustomerUseCase;
        this.registerCustomerWebMapper = registerCustomerWebMapper;
    }

    //register customer
    @PostMapping("/register")
    public ResponseEntity<CustomerRegisterResponseDTO> registerCustomer(
            @Valid @RequestBody CustomerRegisterRequestDTO customerRegisterRequestDTO
    ){
        CustomerRegisterCommand toCommand = registerCustomerWebMapper.toCustomerRegisterCommand(customerRegisterRequestDTO);
        CustomerRegisterResult toUseCase =  registerCustomerUseCase.registerCustomer(toCommand);
        CustomerRegisterResponseDTO toResponseDTO = registerCustomerWebMapper.toCustomerRegisterResponseDTO(toUseCase);

        return ResponseEntity.status(HttpStatus.CREATED).body(toResponseDTO);
    }
}
