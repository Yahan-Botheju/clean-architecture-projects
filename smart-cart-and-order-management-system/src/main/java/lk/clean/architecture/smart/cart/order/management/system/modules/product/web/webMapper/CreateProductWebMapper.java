package lk.clean.architecture.smart.cart.order.management.system.modules.product.web.webMapper;

import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.records.CreateProductCommand;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.usecase.records.CreateProductResult;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.web.DTOs.CreateProductRequestDTO;
import lk.clean.architecture.smart.cart.order.management.system.modules.product.web.DTOs.CreateProductResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateProductWebMapper {

    //requestDTO to usecase obj
    CreateProductCommand toCreateProductCommand(CreateProductRequestDTO createProductRequestDTO);

    //domain model to responseDTO
    CreateProductResponseDTO toResponseDTO(CreateProductResult createProductResult);
}
