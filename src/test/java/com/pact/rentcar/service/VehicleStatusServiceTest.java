package com.pact.rentcar.service;

import com.pact.rentcar.model.Vehicle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional // ACHTUNG! TO MUSI BYC
public class VehicleStatusServiceTest {

    @Autowired
    private VehicleService vehicleStatusService;

//    @Test
//    public void shouldReturnCorrectRegistration() {
//        Long vehicleID = 1L;
//        String CorrectRegistration = "GD1111";
//
//        Vehicle vehicle = vehicleService.getVehicleByID(vehicleID);
//        assertThat(vehicle.getRegistration()).isEqualTo(CorrectRegistration);
//    }
//
//    @Test
//    public void shouldReturnUncorrectBrand() {
//        Long vehicleID = 2L;
//        String inCorrectBrand = "Volvo";
//
//        Vehicle vehicle = vehicleService.getVehicleByID(vehicleID);
//        assertNotEquals(vehicle, inCorrectBrand);
//    }


}