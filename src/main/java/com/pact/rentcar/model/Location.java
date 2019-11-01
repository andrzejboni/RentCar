package com.pact.rentcar.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {

	@Id
	@Column(name = "ID")
	private Long id;

	private String country;
	private String city;
	private String adres;
	private String email;
	private String phone;
}
