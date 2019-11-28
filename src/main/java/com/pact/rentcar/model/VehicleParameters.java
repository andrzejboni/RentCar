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
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

//    private Long vehicleID;
//    @Id
//    @OneToOne(fetch = FetchType.EAGER)
//    private Vehicle vehicle;

//    @JoinColumn(name = "vehicle_id")


    //    @Column(unique = true, nullable = false)

    @Id
    private Long id;




    @OneToOne
    private Vehicle vehicle;


    /** user with this associated settings */
//    @MapsId
//    @OneToOne
//    @JoinColumn(name = "id")
//    private Vehicle vehicle;


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

//    @ManyToOne
//    Vehicle vehicle;




}