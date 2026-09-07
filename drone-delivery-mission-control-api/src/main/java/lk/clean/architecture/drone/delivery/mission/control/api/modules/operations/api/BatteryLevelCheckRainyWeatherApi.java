package lk.clean.architecture.drone.delivery.mission.control.api.modules.operations.api;

public interface BatteryLevelCheckRainyWeatherApi {

    //check current battery level in rainy weather
    boolean batteryLevelCheckRainyWeather(String pickUpLocation, String deliveryLocation, double currentBatteryLevel);
}
