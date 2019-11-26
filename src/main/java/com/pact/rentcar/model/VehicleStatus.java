package com.pact.rentcar.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class VehicleStatus {

    @Id
    private String vehicleStatCode;
    private boolean available;
}
