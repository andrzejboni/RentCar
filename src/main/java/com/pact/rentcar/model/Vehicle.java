package com.pact.rentcar.model;

import lombok.*;
import javax.persistence.*;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Vehicle {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long id;

//    @Column(unique = true, nullable = false)

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** user settings */
//    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vehicle")

    @OneToOne(mappedBy = "vehicle")
    private VehicleParameters vehicleParameters;

    private String registration;
    private String brand;
    private String model;
    private Double dailyFee;

    @ManyToOne
    Location location;

    @ManyToOne
    VehicleStatus vehicleStatus;
}
