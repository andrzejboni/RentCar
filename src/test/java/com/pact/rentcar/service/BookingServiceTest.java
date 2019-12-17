package com.pact.rentcar.service;

import com.pact.rentcar.model.AppUser;
import com.pact.rentcar.model.Booking;
import com.pact.rentcar.model.Vehicle;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional //  ACHTUNG! TO MUSI BYC
public class BookingServiceTest {

    @Autowired
    private BookingService bookingService;

//
//    @Test
//    public void findAllByAppUserIdTest() {
//
//
//
//        List<Booking> usersBookings = bookingService.findAllBookingsByUsername();
//        assertThat(usersBookings.get(0).getLocation().getId()).isEqualTo(locationID);
//    }





}
