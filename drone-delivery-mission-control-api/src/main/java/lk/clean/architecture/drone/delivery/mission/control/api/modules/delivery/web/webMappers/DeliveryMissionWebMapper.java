package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.webMappers;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CompleteMissionResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.StartMissionResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.CompleteMissionResponseDTO;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.StartMissionResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliveryMissionWebMapper {

    /* __CREATE_MISSION__ */

    //domain model to response dto
    StartMissionResponseDTO toStartMissionResponse(StartMissionResult startMissionResult);


    /* __COMPLETE_MISSION__ */

    //domain model to responseDTO
    CompleteMissionResponseDTO toCompleteMissionResponse(CompleteMissionResult completeMissionResult);

}
