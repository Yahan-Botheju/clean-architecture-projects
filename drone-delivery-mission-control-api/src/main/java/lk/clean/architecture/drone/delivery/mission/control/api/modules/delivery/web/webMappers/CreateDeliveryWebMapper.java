package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.webMappers;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CreateDeliveryCommand;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CreateDeliveryResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.CreateDeliveryRequestDTO;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.CreateDeliveryResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CreateDeliveryWebMapper {

    //dto to command
    CreateDeliveryCommand toDeliveryCommand(CreateDeliveryRequestDTO createDeliveryRequestDTO);

    //domain model to response
    CreateDeliveryResponseDTO toDeliveryResponseDTO(CreateDeliveryResult createDeliveryResult);
}
