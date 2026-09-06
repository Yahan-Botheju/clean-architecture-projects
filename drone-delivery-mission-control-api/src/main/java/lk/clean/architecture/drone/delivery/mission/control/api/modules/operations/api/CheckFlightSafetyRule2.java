package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.AirSpaceStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.WeatherCondition;

public interface CheckFlightSafetyRule2 {

    //check flight safety rule 2
    boolean checkFlightSafetyRule2(WeatherCondition weatherCondition, AirSpaceStatus airSpaceStatus);
}
