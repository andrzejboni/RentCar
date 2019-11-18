package com.pact.rentcar.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddVehicleParametersRequest {

    private Long vehicleID; // UWAGA MOZE TO BYC NIEPOTRZEBEN

    private String bodytype;
    private Integer productionYear;
    private String fuelType;
    private Integer power;
    private String gearbox;
    private Integer frontWheelDrive;
    private Integer doorsNumber;
    private Integer seatsNumber;
    private String color;
    private Integer metallic;
    private String photoName;
    private String description;
}
