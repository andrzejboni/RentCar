package com.pact.rentcar.model.dto.request;

import com.pact.rentcar.model.AppUser;
import com.pact.rentcar.model.Location;
import com.pact.rentcar.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBookingRequest {

    private Timestamp recipeDate;
    private Timestamp returnDate;
    private Double totalCost;

    AppUser appUser;
    Location location;
    Vehicle vehicle;

}
