package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.webMappers;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.records.CompleteMissionResult;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs.CompleteMissionResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CompleteMissionWebMapper {

        //domain model to responseDTO
        CompleteMissionResponseDTO toResponse(CompleteMissionResult completeMissionResult);
}
