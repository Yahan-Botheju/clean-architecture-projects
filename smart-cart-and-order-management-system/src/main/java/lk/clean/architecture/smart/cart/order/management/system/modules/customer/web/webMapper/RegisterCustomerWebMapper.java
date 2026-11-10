package lk.clean.architecture.smart.cart.order.management.system.modules.customer.web.webMapper;

import lk.clean.architecture.smart.cart.order.management.system.modules.customer.usecase.records.CustomerRegisterCommand;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.usecase.records.CustomerRegisterResult;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.web.DTOs.CustomerRegisterRequestDTO;
import lk.clean.architecture.smart.cart.order.management.system.modules.customer.web.DTOs.CustomerRegisterResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RegisterCustomerWebMapper {

    //requestDTO to usecase obj
    CustomerRegisterCommand toCustomerRegisterCommand(CustomerRegisterRequestDTO customerRegisterRequestDTO);

    //domain model to responseDTO
    CustomerRegisterResponseDTO toCustomerRegisterResponseDTO(CustomerRegisterResult customerRegisterResult);
}
