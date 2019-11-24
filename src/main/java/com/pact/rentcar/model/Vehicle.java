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
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String registration;
    private String brand;
    private String model;
    private Double dailyFee;

    @ManyToOne
    Location location;

    @ManyToOne
    VehicleStatus vehicleStatus;
}
