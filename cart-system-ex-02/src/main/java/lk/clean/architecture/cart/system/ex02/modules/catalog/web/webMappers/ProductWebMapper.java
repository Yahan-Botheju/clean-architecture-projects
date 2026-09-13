package lk.clean.architecture.cart.system.ex02.modules.catalog.web.webMappers;

import lk.clean.architecture.cart.system.ex02.modules.catalog.usecase.records.CreateProductCommand;
import lk.clean.architecture.cart.system.ex02.modules.catalog.usecase.records.CreateProductResult;
import lk.clean.architecture.cart.system.ex02.modules.catalog.web.DTOs.CreateProductRequestDTO;
import lk.clean.architecture.cart.system.ex02.modules.catalog.web.DTOs.CreateProductResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductWebMapper {

    //requestDTO to usecase obj
    CreateProductCommand  toCreateProductCommand(CreateProductRequestDTO createProductRequestDTO);

    //domain model to response dto
    CreateProductResponseDTO toCreateProductResponseDTO(CreateProductResult createProductResult);
}
