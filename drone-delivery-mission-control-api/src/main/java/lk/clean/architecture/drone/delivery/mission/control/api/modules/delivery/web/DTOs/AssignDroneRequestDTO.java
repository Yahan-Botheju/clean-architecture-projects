package lk.clean.architecture.drone.delivery.mission.control.api.modules.delivery.web.DTOs;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssignDroneRequestDTO {
    @NotNull(message = "Drone ID cannot be empty")
    private UUID droneId;
}
