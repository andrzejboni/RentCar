package com.pact.rentcar.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

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
    private BigDecimal dailyFee;

    @ManyToOne
    Location location;

    @ManyToOne
    VehicleStatus vehicleStatus;
}
