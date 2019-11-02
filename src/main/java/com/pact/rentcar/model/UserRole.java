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

public class UserRole {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String type;

}
