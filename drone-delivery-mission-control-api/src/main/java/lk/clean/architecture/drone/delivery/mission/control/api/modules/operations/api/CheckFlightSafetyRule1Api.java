package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.AirSpaceStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.WeatherCondition;

public interface CheckFlightSafetyRule1Api {

    //check flight safety rule 1
    public boolean checkFlightSafetyRule1(WeatherCondition weatherCondition, AirSpaceStatus airSpaceStatus);
}
