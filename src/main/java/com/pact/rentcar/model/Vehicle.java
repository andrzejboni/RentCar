package com.pact.rentcar.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String registration;
	private String brand;
	private String model;
	private BigDecimal dailyFee;
	private Long locationId;
	private String vehicleStatus;
	private Boolean bestOffer;

	@ManyToMany(cascade = { CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH })
	@JoinTable(name = "Eqp", joinColumns = @JoinColumn(name = "vehicleID"), inverseJoinColumns = @JoinColumn(name = "equipmentID"))
	private List<Equipment> equipmentList = new ArrayList<Equipment>();

	@OneToOne(mappedBy = "vehicle")
	private VehicleParameters vehicleParameters;

	@JsonIgnore
	@OneToMany(mappedBy = "vehicle")
	private Set<Comment> comments;

}