package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.infrastructure.configs;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.BatteryLevelCheckRainyWeatherApi;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.CheckFlightSafetyRule1Api;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api.CheckFlightSafetyRule2Api;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.repositories.AirStatusOperationAssessmentRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.repositories.WeatherConditionOperationAssessmentRepository;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.usecase.api.BatteryLevelCheckRainyWeatherApiImpl;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.usecase.api.CheckFlightSafetyRule1ApiImpl;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.usecase.api.CheckFlightSafetyRule2ApiImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseBeanConfigs {

    //flight safety rule 1
    @Bean
    public CheckFlightSafetyRule1Api checkFlightSafetyRule1(
            WeatherConditionOperationAssessmentRepository weatherConditionOperationAssessmentRepository,
            AirStatusOperationAssessmentRepository airStatusOperationAssessmentRepository
    ){
        return new CheckFlightSafetyRule1ApiImpl(weatherConditionOperationAssessmentRepository, airStatusOperationAssessmentRepository);
    }

    //flight safety rule 2
    @Bean
    public CheckFlightSafetyRule2Api checkFlightSafetyRule2(
            WeatherConditionOperationAssessmentRepository weatherConditionOperationAssessmentRepository,
            AirStatusOperationAssessmentRepository airStatusOperationAssessmentRepository
    ){
        return new CheckFlightSafetyRule2ApiImpl(weatherConditionOperationAssessmentRepository, airStatusOperationAssessmentRepository);
    }

    //flight check in rainy weather
    @Bean
    public BatteryLevelCheckRainyWeatherApi batteryLevelCheckRainyWeather(){
        return new BatteryLevelCheckRainyWeatherApiImpl();
    }
}
