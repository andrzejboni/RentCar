package com.pact.rentcar.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long userId;
    private Long vehicleId;
    private Long locationId;
    private Timestamp receiptDate;
    private Timestamp returnDate;
    private String bookingStateCode;
    private BigDecimal totalCost;


}
