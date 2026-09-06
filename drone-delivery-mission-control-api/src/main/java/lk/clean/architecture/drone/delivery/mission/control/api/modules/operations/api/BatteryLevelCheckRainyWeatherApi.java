package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.AirSpaceStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.WeatherCondition;

public interface BatteryLevelCheckRainyWeatherApi {

    //check current battery level in rainy weather
    public boolean batteryLevelCheckRainyWeather(WeatherCondition weatherCondition, AirSpaceStatus airSpaceStatus, double currentBatteryLevel);
}
