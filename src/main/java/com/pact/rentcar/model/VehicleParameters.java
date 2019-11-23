package com.pact.rentcar.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class VehicleParameters {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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

    @ManyToOne
    Vehicle vehicle;

}