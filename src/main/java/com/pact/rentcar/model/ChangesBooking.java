package com.pact.rentcar.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChangesBooking  {

	@Id
	private Long id;

	private Long bookingId;
	private LocalDateTime changesDate;
	private String who;
	private String PC;

}
