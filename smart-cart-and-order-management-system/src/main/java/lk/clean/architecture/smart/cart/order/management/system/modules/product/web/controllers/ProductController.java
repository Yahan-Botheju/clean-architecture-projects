package lk.clean.architecture.smart.cart.order.management.system.modules.product.web.controllers;

import jakarta.validation.Valid;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.ChangeProductPriceUseCase;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.CreateProductUseCase;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.records.ChangeProductPriceCommand;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.records.ChangeProductPriceResult;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.records.CreateProductCommand;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.records.CreateProductResult;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.web.DTOs.ChangeProductPriceRequestDTO;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.web.DTOs.ChangeProductPriceResponseDTO;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.web.DTOs.CreateProductRequestDTO;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.web.DTOs.CreateProductResponseDTO;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.web.webMapper.ChangeProductPriceWebMapper;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.web.webMapper.CreateProductWebMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    //inject required dependencies
    private final CreateProductUseCase createProductUseCase;
    private final CreateProductWebMapper createProductWebMapper;
    private final ChangeProductPriceUseCase changeProductPriceUseCase;
    private final ChangeProductPriceWebMapper changeProductPriceWebMapper;

    public ProductController(
            CreateProductUseCase createProductUseCase,
            CreateProductWebMapper createProductWebMapper,
            ChangeProductPriceUseCase changeProductPriceUseCase,
            ChangeProductPriceWebMapper changeProductPriceWebMapper
    ) {
        this.createProductUseCase = createProductUseCase;
        this.createProductWebMapper = createProductWebMapper;
        this.changeProductPriceUseCase = changeProductPriceUseCase;
        this.changeProductPriceWebMapper = changeProductPriceWebMapper;
    }

    //create product
    @PostMapping
    public ResponseEntity<CreateProductResponseDTO> createProduct(
            @Valid @RequestBody CreateProductRequestDTO createProductRequestDTO
    ){
        CreateProductCommand toCommand = createProductWebMapper.toCreateProductCommand(createProductRequestDTO);
        CreateProductResult toUseCase =  createProductUseCase.createProduct(toCommand);
        CreateProductResponseDTO responseDTO = createProductWebMapper.toResponseDTO(toUseCase);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }

    //change product price
    @PostMapping("/change-price")
    public ResponseEntity<ChangeProductPriceResponseDTO> changeProductPrice(
            @Valid @RequestBody ChangeProductPriceRequestDTO changeProductPriceRequestDTO
    ){
        ChangeProductPriceCommand toCommand = changeProductPriceWebMapper.toChangeProductPriceCommand(changeProductPriceRequestDTO);
        ChangeProductPriceResult toUseCase = changeProductPriceUseCase.changeProductPrice(toCommand);
        ChangeProductPriceResponseDTO responseDTO = changeProductPriceWebMapper.toChangePriceResponseDTO(toUseCase);

        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }
}
