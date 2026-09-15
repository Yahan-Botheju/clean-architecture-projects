package lk.clean.architecture.cart.system.ex02.modules.cart.web.webMappers;

import lk.clean.architecture.cart.system.ex02.modules.cart.domain.models.CartItem;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.*;
import lk.clean.architecture.cart.system.ex02.modules.cart.web.DTOs.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CartWebMapper {

    /* __ADD_TO_CART__ */

    //requestDTO to usecase obj
    AddToCartCommand toAddToCartCommand(AddToCartRequestDTO addToCartRequestDTO);

    //domain model to responseDTO
    AddToCartResponseDTO  toAddToCartResponseDTO(AddToCartResult addToCartResult);


    /* __GET_CART__ */

    //domain model to responseDTO
    GetCartResponseDTO toGetCartResponseDTO(GetCartResult getCartResult);


    /* __UPDATE_CART_ITEM__ */

    //requestDTO to usecase obj
    UpdateCartItemCommand toUpdateCartCommand(UpdateCartItemRequestDTO updateCartItemRequestDTO);

    //domain model to responseDTO
    UpdateCartItemResponseDTO toUpdateCartItemResponseDTO(UpdateCartItemResult updateCartItemResult);


    /* __REMOVE_FROM_CART__ */

    //requestDTO to usecase obj
    RemoveFromCartCommand toRemoveFromCartCommand(RemoveFromCartRequestDTO removeFromCartRequestDTO);

    //domain model to responseDTO
    RemoveFromCartResponseDTO toRemoveFromCartResponseDTO(RemoveFromCartResult removeFromCartResult);
}
