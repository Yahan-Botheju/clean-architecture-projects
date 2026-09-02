package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.models;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.AirSpaceStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.WeatherCondition;

public record OperationalAssessment(
        WeatherCondition weatherCondition,
        AirSpaceStatus airSpaceStatus,
        boolean allowed,
        String reason
) {}
