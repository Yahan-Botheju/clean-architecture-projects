package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.api;

import java.util.UUID;

public interface DroneTaskCompleteApi {

    //When drone delivery task is complete
    public void droneTaskComplete(UUID droneId);
}
