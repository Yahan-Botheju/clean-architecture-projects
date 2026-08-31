package lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.models;

import lk.clean.architecture.drone.delivery.mission.control.api.modules.drone.domain.enums.DroneStatus;

import java.util.UUID;

public class Drone {

    static final double maxPayloadingKg = 0.5;

    private UUID droneId;
    private String serialNumber;
    private DroneStatus droneStatus;
    private double payloadingKg;
    private double batteryPercentage;

    public Drone(UUID droneId, String serialNumber, DroneStatus droneStatus, double payloadingKg,double batteryPercentage) {
        this.droneId = droneId;
        this.serialNumber = serialNumber;
        this.droneStatus = droneStatus;
        this.payloadingKg = payloadingKg;
        this.batteryPercentage = batteryPercentage;
    }

    public UUID getDroneId() { return droneId; }
    public String getSerialNumber() { return serialNumber; }
    public DroneStatus getDroneStatus() { return droneStatus; }
    public double getPayloadingKg() { return payloadingKg; }
    public double getBatteryPercentage() { return batteryPercentage; }



    /* __DOMAIN_LOGIC__ */


    //check delivery pay load
    public void checkDronePayload(){
        if(this.payloadingKg >= maxPayloadingKg){
            throw new IllegalStateException("Pay loading KG exceeds maximum allowed");
        }
    }
}
