package com.pact.rentcar.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AppUser {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String phone;

	@ManyToMany(fetch = FetchType.EAGER) //oznacza pobieranie natychmiastowe
	private Set<UserRole> roles;


	}

