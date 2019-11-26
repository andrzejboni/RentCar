package com.pact.rentcar.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Timestamp recipeDate;
    private Timestamp returnDate;
    private Double totalCost;

    @ManyToOne
    AppUser appUser;

    @ManyToOne
    Location location;

    @ManyToOne
    Vehicle vehicle;

}
