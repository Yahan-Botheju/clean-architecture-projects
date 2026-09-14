package lk.clean.architecture.cart.system.ex02.modules.cart.web.webMappers;

import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.AddToCartCommand;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.AddToCartResult;
import lk.clean.architecture.cart.system.ex02.modules.cart.web.DTOs.AddToCartRequestDTO;
import lk.clean.architecture.cart.system.ex02.modules.cart.web.DTOs.AddToCartResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartWebMapper {

    //requestDTO to usecase obj
    AddToCartCommand toAddToCartCommand(AddToCartRequestDTO addToCartRequestDTO);

    //domain model to responseDTO
    AddToCartResponseDTO  toAddToCartResponseDTO(AddToCartResult addToCartResult);
}
