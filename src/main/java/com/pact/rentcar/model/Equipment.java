package com.pact.rentcar.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipment  {

	@Id
	@Column(name = "equipmentCode")
	@Size(max = 3)
	private String equipmentCode;

	private String description;

	@ManyToMany(mappedBy="equipmentList")
	private List<Vehicle> carList = new ArrayList<Vehicle>();


}