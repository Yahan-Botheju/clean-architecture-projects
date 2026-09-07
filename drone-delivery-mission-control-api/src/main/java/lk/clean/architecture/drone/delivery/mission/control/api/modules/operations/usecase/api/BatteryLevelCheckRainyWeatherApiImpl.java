package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.usecase.api;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.BatteryLevelCheckRainyWeatherApi;
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


        //check pickup weather condition check
        OperationalAssessment pickUpWeather = weatherConditionOperationAssessmentRepository.getPickUpLocationWeatherCondition(pickUpLocation);
        OperationalAssessment pickUpAirStatus = airStatusOperationAssessmentRepository.getPickUpLocationAirStatus(pickUpLocation);

        //check drop off weather condition check
        OperationalAssessment deliveryWeather = weatherConditionOperationAssessmentRepository.getDropOffLocationWeatherCondition(deliveryLocation);
        OperationalAssessment deliveryAirStatus = airStatusOperationAssessmentRepository.getDropOffLocationAirStatus(deliveryLocation);

        //pickup domain model
        OperationalAssessment pickupOperation = OperationalAssessment.createOperationalAssessment(
                pickUpWeather.getWeatherCondition(),
                pickUpAirStatus.getAirSpaceStatus()
        );

        //delivery domain model
        OperationalAssessment deliveryOperation = OperationalAssessment.createOperationalAssessment(
                deliveryWeather.getWeatherCondition(),
                deliveryAirStatus.getAirSpaceStatus()
        );


        //use domain logic
        pickupOperation.checkBatteryLevelInRainyWeather(currentBatteryLevel);
        deliveryOperation.checkBatteryLevelInRainyWeather(currentBatteryLevel);

        return pickupOperation.isAllowed() && deliveryOperation.isAllowed();
    }
}
