package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.models;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.AirSpaceStatus;
import lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.domain.enums.WeatherCondition;

public class OperationalAssessment {
    private WeatherCondition weatherCondition;
    private AirSpaceStatus airSpaceStatus;
    private boolean allowed;
    private String reason;

    public OperationalAssessment(
            WeatherCondition weatherCondition,
            AirSpaceStatus airSpaceStatus
    ) {
        this.weatherCondition = weatherCondition;
        this.airSpaceStatus = airSpaceStatus;
        this.allowed = false;
        this.reason = "Pending assessment";
    }

    public WeatherCondition getWeatherCondition() { return weatherCondition; }
    public AirSpaceStatus getAirSpaceStatus() { return airSpaceStatus; }
    public boolean isAllowed() { return allowed; }
    public String getReason() { return reason; }


    /* __DOMAIN_LOGICS__ */


    //check weather and air is okay to fly the drone
    public void checkFlightSafetyRule1(){
        if(this.weatherCondition == WeatherCondition.STORM
                && (this.airSpaceStatus == AirSpaceStatus.CLOSED
                || this.airSpaceStatus == AirSpaceStatus.RESTRICTED)
        ){
            throw new IllegalArgumentException("Cannot continue mission under these condition");
        }
        this.allowed = true;
    }

    //check battery level in rainy weather for fly
    public void checkBatteryLevelInRainyWeather(double currentBatteryLevel){
        boolean batteryPercentageCheck = currentBatteryLevel > 50;
        if(this.weatherCondition == WeatherCondition.RAINY && !batteryPercentageCheck){
            throw new IllegalArgumentException("Cannot continue mission under these condition");
        }
        this.allowed = true;
    }

    //check weather and air is ok to fly the drone
    public void checkFlightSafetyRule2(){
       boolean weatherConditionCheck = (this.weatherCondition == WeatherCondition.CLEAR
               || weatherCondition == WeatherCondition.CLOUDY);
       boolean airSpaceStatusCheck = (this.airSpaceStatus == AirSpaceStatus.OPEN);

       if(!weatherConditionCheck || !airSpaceStatusCheck){
           throw new IllegalArgumentException("Cannot continue mission under these condition");
       }
       this.allowed = true;
    }


    //create factory method

    public static OperationalAssessment createOperationalAssessment(
            WeatherCondition weatherCondition,
            AirSpaceStatus airSpaceStatus
    ){
        return new OperationalAssessment(weatherCondition,airSpaceStatus);
    }
}
