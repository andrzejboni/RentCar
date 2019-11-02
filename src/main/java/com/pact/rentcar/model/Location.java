package com.pact.rentcar.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;


@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Location {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String country;
	private String city;
	private String adres;
	private String email;
	private String phone;
}
