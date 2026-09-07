package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.BatteryLevelCheckRainyWeatherApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.AirSpaceStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.WeatherCondition;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.models.OperationalAssessment;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.repositories.AirStatusOperationAssessmentRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.repositories.WeatherConditionOperationAssessmentRepository;

public class BatteryLevelCheckRainyWeatherApiImpl implements BatteryLevelCheckRainyWeatherApi {

    //inject required dependencies
    private final WeatherConditionOperationAssessmentRepository weatherConditionOperationAssessmentRepository;
    private final AirStatusOperationAssessmentRepository airStatusOperationAssessmentRepository;

    public BatteryLevelCheckRainyWeatherApiImpl(WeatherConditionOperationAssessmentRepository weatherConditionOperationAssessmentRepository, AirStatusOperationAssessmentRepository airStatusOperationAssessmentRepository) {
        this.weatherConditionOperationAssessmentRepository = weatherConditionOperationAssessmentRepository;
        this.airStatusOperationAssessmentRepository = airStatusOperationAssessmentRepository;
    }


    //check current battery level in rainy weather
    public boolean batteryLevelCheckRainyWeather(String pickUpLocation, String deliveryLocation, double currentBatteryLevel){

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
