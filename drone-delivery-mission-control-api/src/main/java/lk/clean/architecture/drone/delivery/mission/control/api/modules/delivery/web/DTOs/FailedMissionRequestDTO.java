package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs;

import jakarta.validation.constraints.NotNull;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.usecase.enums.FailureReasonStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FailedMissionRequestDTO {
    @NotNull(message = "Reason cannot be empty")
    private FailureReasonStatus failureReasonStatus;
}
