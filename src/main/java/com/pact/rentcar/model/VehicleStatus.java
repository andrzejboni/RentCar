package com.pact.rentcar.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class VehicleStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String vehicleStatCode;

    //	private String description;
    private String woda;


}
