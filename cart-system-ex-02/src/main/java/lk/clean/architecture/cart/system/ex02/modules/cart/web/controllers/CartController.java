package lk.clean.architecture.cart.system.ex02.modules.cart.web.controllers;

import jakarta.validation.Valid;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.AddToCartUseCase;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.GetCartUseCase;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.RemoveFromCartUseCase;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.UpdateCartItemUseCase;
import lk.clean.architecture.cart.system.ex02.modules.cart.usecase.records.*;
import lk.clean.architecture.cart.system.ex02.modules.cart.web.DTOs.*;
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


    //get cart
    @GetMapping
    public ResponseEntity<GetCartResponseDTO> getCart(
            @Valid @RequestBody GetCartRequestDTO getCartRequestDTO
    ){
        GetCartCommand getCartCommand = cartWebMapper.toGetCartCommand(getCartRequestDTO);
        GetCartResult toUseCase = getCartUseCase.getCart(getCartCommand);
        GetCartResponseDTO responseDTO = cartWebMapper.toGetCartResponseDTO(toUseCase);

        return ResponseEntity.ok(responseDTO);
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

    //delete item from cart
    @DeleteMapping
    public ResponseEntity<RemoveFromCartResponseDTO> removeFromCart(
            @Valid @RequestBody RemoveFromCartRequestDTO removeFromCartRequestDTO
    ){
        RemoveFromCartCommand removeFromCartCommand = cartWebMapper.toRemoveFromCartCommand(removeFromCartRequestDTO);
        RemoveFromCartResult toUseCase = removeFromCartUseCase.removeFromCart(removeFromCartCommand);
        RemoveFromCartResponseDTO responseDTO = cartWebMapper.toRemoveFromCartResponseDTO(toUseCase);

        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

}