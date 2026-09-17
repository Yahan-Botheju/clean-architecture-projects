package lk.clean.architecture.cart.system.ex02.modules.cart.web.controllers;

import jakarta.validation.Valid;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.AddToCartUseCase;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.GetCartUseCase;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.RemoveFromCartUseCase;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.UpdateCartItemUseCase;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.AddToCartCommand;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.AddToCartResult;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.UpdateCartItemCommand;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.UpdateCartItemResult;
import lk.clean.architecture.cart.system.ex02.modules.cart.web.DTOs.AddToCartRequestDTO;
import lk.clean.architecture.cart.system.ex02.modules.cart.web.DTOs.AddToCartResponseDTO;
import lk.clean.architecture.cart.system.ex02.modules.cart.web.DTOs.UpdateCartItemRequestDTO;
import lk.clean.architecture.cart.system.ex02.modules.cart.web.DTOs.UpdateCartItemResponseDTO;
import lk.clean.architecture.cart.system.ex02.modules.cart.web.webMappers.CartWebMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/carts")
public class CartController {

    //inject required dependencies
    private final AddToCartUseCase addToCartUseCase;
    private final GetCartUseCase getCartUseCase;
    private final UpdateCartItemUseCase updateCartItemUseCase;
    private final RemoveFromCartUseCase removeFromCartUseCase;
    private final CartWebMapper cartWebMapper;

    public CartController(
            AddToCartUseCase addToCartUseCase,
            GetCartUseCase getCartUseCase,
            UpdateCartItemUseCase updateCartItemUseCase,
            RemoveFromCartUseCase removeFromCartUseCase,
            CartWebMapper cartWebMapper
    ) {
        this.addToCartUseCase = addToCartUseCase;
        this.getCartUseCase = getCartUseCase;
        this.updateCartItemUseCase = updateCartItemUseCase;
        this.removeFromCartUseCase = removeFromCartUseCase;
        this.cartWebMapper = cartWebMapper;
    }

    //add to cart
    @PostMapping("/add-to-cart")
    public ResponseEntity<AddToCartResponseDTO> addToCart(
            @Valid @RequestBody AddToCartRequestDTO addToCartRequestDTO
    ){
        AddToCartCommand toAddToCartCommand = cartWebMapper.toAddToCartCommand(addToCartRequestDTO);
        AddToCartResult toUseCase = addToCartUseCase.execute(toAddToCartCommand);
        AddToCartResponseDTO responseDTO = cartWebMapper.toAddToCartResponseDTO(toUseCase);

        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    //update cart
    @PutMapping
    public ResponseEntity<UpdateCartItemResponseDTO> updateCart(
            @Valid @RequestBody UpdateCartItemRequestDTO updateCartItemRequestDTO
    ){
        UpdateCartItemCommand updateCartItemCommand = cartWebMapper.toUpdateCartCommand(updateCartItemRequestDTO);
        UpdateCartItemResult toUseCase = updateCartItemUseCase.execute(updateCartItemCommand);
        UpdateCartItemResponseDTO responseDTO = cartWebMapper.toUpdateCartItemResponseDTO(toUseCase);

        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }
}
