package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.webMappers;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CompleteMissionResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.FailedMissionCommand;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.FailedMissionResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.StartMissionResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.CompleteMissionResponseDTO;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.FailedMissionRequestDTO;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.FailedMissionResponseDTO;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.StartMissionResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DeliveryMissionWebMapper {

    /* __START_MISSION__ */

    //domain model to response dto
    StartMissionResponseDTO toStartMissionResponse(StartMissionResult startMissionResult);


    /* __COMPLETE_MISSION__ */

    //domain model to responseDTO
    CompleteMissionResponseDTO toCompleteMissionResponse(CompleteMissionResult completeMissionResult);


    /* __COMPLETE_MISSION__ */

    //requestDTO to usecase object
    FailedMissionCommand toFailedMissionCommand(FailedMissionRequestDTO failedMissionRequestDTO);

    //domain model to responseDTO
    FailedMissionResponseDTO toFailedMissionResponseDto(FailedMissionResult failedMissionResult);

}
