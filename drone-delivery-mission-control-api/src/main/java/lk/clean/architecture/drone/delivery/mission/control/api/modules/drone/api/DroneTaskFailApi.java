package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api;

import java.util.UUID;

public interface DroneTaskFailApi {

    //drone task fail
    public void droneTaskFail(UUID droneId);
}
