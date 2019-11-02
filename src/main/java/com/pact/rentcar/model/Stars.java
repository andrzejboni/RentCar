package com.pact.rentcar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Stars  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//	private Long vehicleId;
    private Integer stars;

    @ManyToOne
    Vehicle vehicle;


}
