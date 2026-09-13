package lk.clean.architecture.cart.system.ex02.modules.catalog.web.controllers;

import lk.clean.architecture.cart.system.ex02.modules.catalog.usecase.CreateProductUseCase;
import lk.clean.architecture.cart.system.ex02.modules.catalog.web.webMappers.ProductWebMapper;
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
}
