package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.models;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.enums.DroneStatus;

import java.util.UUID;

public class Drone {
    private UUID droneId;
    private String serialNumber;
    private DroneStatus droneStatus;
    private double maxPayloadingKg;
    private double batteryPercentage;

    public Drone(UUID droneId, String serialNumber, DroneStatus droneStatus, double maxPayloadingKg, double batteryPercentage) {
        this.droneId = droneId;
        this.serialNumber = serialNumber;
        this.droneStatus = droneStatus;
        this.maxPayloadingKg = maxPayloadingKg;
        this.batteryPercentage = batteryPercentage;
    }

    public UUID getDroneId() { return droneId; }
    public String getSerialNumber() { return serialNumber; }
    public DroneStatus getDroneStatus() { return droneStatus; }
    public double getMaxPayloadingKg() { return maxPayloadingKg; }
    public double getBatteryPercentage() { return batteryPercentage; }



}
