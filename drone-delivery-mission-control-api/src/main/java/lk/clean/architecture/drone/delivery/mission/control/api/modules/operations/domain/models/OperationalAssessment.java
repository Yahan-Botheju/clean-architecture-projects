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
            AirSpaceStatus airSpaceStatus,
            boolean allowed, String reason
    ) {
        this.weatherCondition = weatherCondition;
        this.airSpaceStatus = airSpaceStatus;
        this.allowed = allowed;
        this.reason = reason;
    }

    public WeatherCondition getWeatherCondition() { return weatherCondition; }
    public AirSpaceStatus getAirSpaceStatus() { return airSpaceStatus; }
    public boolean isAllowed() { return allowed; }
    public String getReason() { return reason; }


}
