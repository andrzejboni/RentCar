package com.pact.rentcar.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment  {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long vehicleId;
	private String commentContent;
	private String login;
	private Timestamp creationDate;
	private Integer rating;

	@JsonIgnore
	@ManyToOne(optional = false)
	@JoinColumn(name = "vehicleId", referencedColumnName = "ID", insertable = false, updatable = false)
	private Vehicle vehicle;


}
