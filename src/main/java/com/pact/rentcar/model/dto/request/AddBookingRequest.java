package com.pact.rentcar.model.dto.request;

import com.pact.rentcar.model.AppUser;
import com.pact.rentcar.model.Location;
import com.pact.rentcar.model.Vehicle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddBookingRequest {


    private Date recipeDate;
    private Date  returnDate;
    private Double  totalCost;

    private AppUser  appUser; // appUserID
    private Location  location; // locationID
    private Vehicle  vehicle;    // vehicleID
}
