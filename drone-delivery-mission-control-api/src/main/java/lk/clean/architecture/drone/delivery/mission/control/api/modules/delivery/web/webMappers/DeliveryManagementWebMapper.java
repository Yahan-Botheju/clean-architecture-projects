package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.webMappers;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.AssignDroneResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CancelDeliveryResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CreateDeliveryCommand;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CreateDeliveryResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.AssignDroneResponseDTO;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.CancelDeliveryResponseDTO;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.CreateDeliveryRequestDTO;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.CreateDeliveryResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel ="spring" )
public interface DeliveryManagementWebMapper {

    /* __ASSIGN_DRONE__ */

    //domain model to responseDTO
    AssignDroneResponseDTO toAssignResponseDTO(AssignDroneResult assignDroneResult);


    /* __CREATE_DELIVERY__ */

    //dto to command
    CreateDeliveryCommand toDeliveryCommand(CreateDeliveryRequestDTO createDeliveryRequestDTO);

    //domain model to response
    CreateDeliveryResponseDTO toDeliveryResponseDTO(CreateDeliveryResult createDeliveryResult);


    /* __CANCEL_DELIVERY__ */

    CancelDeliveryResponseDTO  toCancelDeliveryResponseDTO(CancelDeliveryResult cancelDeliveryResult);
}
/* __#13 COMMIT -> create cancel delivery web mapper__   DeliveryManagementWebMapper.java */