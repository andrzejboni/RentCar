package com.pact.rentcar.component;


import com.pact.rentcar.configuration.SecurityConfiguration;
import com.pact.rentcar.model.AppUser;
import com.pact.rentcar.model.UserRole;
import com.pact.rentcar.model.Vehicle;
import com.pact.rentcar.model.VehicleParameters;
import com.pact.rentcar.repository.AppUserRepository;
import com.pact.rentcar.repository.UserRoleRepository;
import com.pact.rentcar.repository.VehicleParametersRepository;
import com.pact.rentcar.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.security.Security;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component // adnotacja sprawia, że klasa uruchomi sie podczas startu apliakcji
public class DataInitializer implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private VehicleParametersRepository vehicleParametersRepository;


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // stworzenie uzytkownikow
        // stowrzenie podstawowych uprawnien

        createInitialRoles();
        createInitialUsers();

        createInitialVehicles();

    }

    private void createInitialUsers() {
        addUser("admin", "admin", "Andrzej", "PinkFloyd", "888777555", "ROLE_USER", "ROLE_ADMIN");
        addUser("user", "user", "Roger", "Waters", "333000888", "ROLE_USER");
    }


    private void createInitialVehicles() {
        addVehicle("GD1234","Honda","Civic", 120.0);
        addVehicle("UG2244","Mazda","Premacy", 100.0);
        addVehicle("PO1234","Volvo","S60", 215.0);

//        addVehicleParameters(1L,"Sedan",1999,"Petrol",90, "auto",1, 3,
//        5, "Red", 1,"", "Nulla porttitor accumsan tincidunt. Curabitur aliquet quam id dui posuere blandit." );

    }

    private void addVehicle(String registration, String brand, String model, Double dailyFee) {
        Optional<Vehicle> searchedVehicle = vehicleRepository.findVehicleByRegistration(registration);
        if (!searchedVehicle.isPresent()) {
            Vehicle vehicle = Vehicle.builder()
                    .registration(registration)
                    .brand(brand)
                    .model(model)
                    .dailyFee(dailyFee).build();

            vehicleRepository.save(vehicle);
        }
    }

    private void addVehicleParameters(Long vehicleID, String bodytype, Integer productionYear, String fuelType, Integer power, String gearbox,
                                                Integer frontWheelDrive, Integer doorsNumber, Integer seatsNumber, String color, Integer metallic, String photoName, String description) {
        Optional<VehicleParameters> searchedVehicleParameters = vehicleParametersRepository.findByVehicleID(vehicleID);
        if (!searchedVehicleParameters.isPresent()) {
            VehicleParameters vehicleParameters = VehicleParameters.builder()
                    .vehicleID(vehicleID) // UWAGA MOŻE SIĘ WYPIERDOLIC
                    .bodytype(bodytype)
                    .productionYear(productionYear)
                    .fuelType(fuelType)
                    .power(power)
                    .gearbox(gearbox)
                    .frontWheelDrive(frontWheelDrive)
                    .doorsNumber(doorsNumber)
                    .seatsNumber(seatsNumber)
                    .color(color)
                    .metallic(metallic)
                    .photoName(photoName)
                    .description(description).build();

            vehicleParametersRepository.save(vehicleParameters);
        }
    }



    private void addUser(String username, String password, String firstName, String lastName, String phone, String... roles) {
        Set<UserRole> userRoles = new HashSet<>();
        for (String role : roles) { // dodajemy doń wszystkie role jakie tylko zostały stworzone(moze byc ich wiecej niz 1)
            Optional<UserRole> singleRole = userRoleRepository.findByName(role);
            if (singleRole.isPresent()) {
                userRoles.add(singleRole.get());
            }
        }
        // wszyskie role zebrane w secie

        Optional<AppUser> searchedAppUser = appUserRepository.findByUsername(username);
        if (!searchedAppUser.isPresent()) {
            AppUser appUser = AppUser.builder()
                    .username(username)
                    .password(passwordEncoder.encode(password))
                    .firstName(firstName)
                    .lastName(lastName)
                    .phone(phone)
                    .roles(userRoles).build();

            appUserRepository.save(appUser);
        }
    }

    private void createInitialRoles() {
        addRole("ROLE_USER");
        addRole("ROLE_ADMIN");
    }

    private void addRole(String name) {
        Optional<UserRole> searchRole = userRoleRepository.findByName(name); // sprawdzamy czy rola już istnieje
        if (!searchRole.isPresent()) { // jeśli nie, dodajemy ją.
            UserRole role = new UserRole();
            role.setName(name);
            userRoleRepository.save(role);
        }
    }
}
