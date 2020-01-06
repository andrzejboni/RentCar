package com.pact.rentcar.controller;
import com.pact.rentcar.model.AppUser;
import com.pact.rentcar.model.Vehicle;
import com.pact.rentcar.service.BookingService;
import com.pact.rentcar.service.VehicleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional // ACHTUNG! TO MUSI BYC
public class  GetUserWithCustomInterfaceControllerTest {

    @Autowired
    private GetUserWithCustomInterfaceController getUserWithCustomInterfaceController;


}
