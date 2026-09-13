package lk.clean.architecture.cart.system.ex02.modules.catalog.web.controllers;

import jakarta.validation.Valid;
import lk.clean.architecture.cart.system.ex02.modules.catalog.usecase.CreateProductUseCase;
import lk.clean.architecture.cart.system.ex02.modules.catalog.usecase.records.CreateProductCommand;
import lk.clean.architecture.cart.system.ex02.modules.catalog.usecase.records.CreateProductResult;
import lk.clean.architecture.cart.system.ex02.modules.catalog.web.DTOs.CreateProductRequestDTO;
import lk.clean.architecture.cart.system.ex02.modules.catalog.web.DTOs.CreateProductResponseDTO;
import lk.clean.architecture.cart.system.ex02.modules.catalog.web.webMappers.ProductWebMapper;
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
    private final ProductWebMapper productWebMapper;

    public ProductController(CreateProductUseCase createProductUseCase, ProductWebMapper productWebMapper) {
        this.createProductUseCase = createProductUseCase;
        this.productWebMapper = productWebMapper;
    }

    //create product
    @PostMapping
    public ResponseEntity<CreateProductResponseDTO> createProduct(
            @Valid @RequestBody CreateProductRequestDTO createProductRequestDTO
    ){
        CreateProductCommand toCreateProductCommand = productWebMapper.toCreateProductCommand(createProductRequestDTO);
        CreateProductResult toUseCase = createProductUseCase.execute(toCreateProductCommand);
        CreateProductResponseDTO responseDTO = productWebMapper.toCreateProductResponseDTO(toUseCase);

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
