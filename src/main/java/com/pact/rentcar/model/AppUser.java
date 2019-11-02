package com.pact.rentcar.model;

import lombok.*;

import javax.persistence.*;
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

	@ManyToMany(fetch = FetchType.EAGER) //oznacza pobieranie natychmiastowe
	private Set<UserRole> roles;

}


//public class AppUser {
//
//	@Id
//	@GeneratedValue(strategy = GenerationType.AUTO)
//	private Long id;
//
//	private String name;
//	private String surname;
//	private String login;
//	private String password;
//	private String email;
//	private String phone;
//
//
//	@ManyToMany(fetch = FetchType.EAGER) //EAGER oznacza pobieranie natychmiastowe
//	private Set<UserRole> userrole;
//
//}
