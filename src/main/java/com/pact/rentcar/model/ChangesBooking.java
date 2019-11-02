package com.pact.rentcar.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
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
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private Long bookingId;
	private LocalDateTime changesDate;
	private String who;
	private String PC;

}
