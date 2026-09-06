package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.BatteryLevelCheckRainyWeatherApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.AirSpaceStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.WeatherCondition;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.models.OperationalAssessment;

public class BatteryLevelCheckRainyWeatherApiImpl implements BatteryLevelCheckRainyWeatherApi {


    //check current battery level in rainy weather
    public boolean batteryLevelCheckRainyWeather(
            WeatherCondition weatherCondition,
            AirSpaceStatus airSpaceStatus,
            double currentBatteryLevel
    ){

        //create domain model
        OperationalAssessment newOperation = OperationalAssessment.createOperationalAssessment(
                weatherCondition,
                airSpaceStatus
        );
        //use domain logic
        newOperation.checkBatteryLevelInRainyWeather(currentBatteryLevel);

        return newOperation.isAllowed();
    }
}
