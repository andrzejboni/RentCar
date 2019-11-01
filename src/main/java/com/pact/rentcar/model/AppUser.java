package com.pact.rentcar.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;
@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class AppUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;
	private String surname;
	private String login;
	private String password;
	private String email;
	private String phone;
	private Date birthDate;
	private String pesel;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "AppUsersRoles", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "userRoleID"))
	private Set<AppUserRole> appUserRolesList = new HashSet<AppUserRole>();

	}

