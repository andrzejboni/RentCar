package com.pact.rentcar.model;

import lombok.*;

import javax.persistence.*;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String surname;
	private String login;
	private String password;
	private String email;
	private String phone;


	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
//	@JoinTable(name = "UserRole", joinColumns = @JoinColumn(name = "userID"), inverseJoinColumns = @JoinColumn(name = "userRoleID"))
	private Set<UserRole> userRolesList = new HashSet<UserRole>();

	}

