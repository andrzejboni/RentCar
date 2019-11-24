package com.pact.rentcar.component;

import com.pact.rentcar.configuration.SecurityConfiguration;
import com.pact.rentcar.model.*;
import com.pact.rentcar.repository.*;
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
    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

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
        addVehicle("GD1111", "Honda", "Civic", 120.0, "Sedan", 1999, "Petrol",
                90, "auto", 1, 3,
                5, "Red", 1, "", "Nulla porttitor accumsan tincidunt. Curabitur aliquet quam id dui posuere blandit.");
        addVehicle("GD2222", "Mazda", "Premacy", 130.0, "Combi", 2006, "LPG",
                110, "manual", 1, 5,
                7, "Blue", 0, "", "Curabitur aliquet quam id dui posuere blandit.");
        addVehicle("GD3333", "Volvo", "S90", 300.0, "Sedan", 2019, "Petrol",
                270, "auto", 0, 5,
                5, "Gold", 1, "", "aliquet quam id dui posuere blandit.");
        addVehicle("GD4444", "Toyota", "Prius", 170.0, "Sedan", 2016, "Hybrid",
                70, "auto", 1, 3,
                5, "Silver", 1, "", "tincidunt aliquet quam id dui posuere  accumsan tincidunt. Curabitur blandit.");
        addVehicle("GD5555", "Tesla", "Model 3", 280.0, "Sedan", 2018, "Electric",
                210, "auto", 1, 5,
                5, "Black", 1, "", " porttitor aliquet quam id dui posuere blandit.Nulla porttitor accumsan tincidunt.");
        addVehicle("GD1234", "Hyundai", "i20", 369.4, "hatchback", 2017, "Petrol",
                85, "manual", 1, 5,
                5, "RedPassion", 1, "", " porttitor aliquet quam id dui posuere blandit.Nulla porttitor accumsan tincidunt.");
    }


    private void addVehicle(String registration, String brand, String model, Double dailyFee, String bodytype, Integer productionYear, String fuelType, Integer power, String gearbox,
                            Integer frontWheelDrive, Integer doorsNumber, Integer seatsNumber, String color, Integer metallic, String photoName, String description
    ) {

        // Tworzę pojazd
        Optional<Vehicle> searchedVehicle = vehicleRepository.findVehicleByRegistration(registration);
        if (!searchedVehicle.isPresent()) {
            Vehicle vehicle = Vehicle.builder()
                    .registration(registration)
                    .brand(brand)
                    .model(model)
                    .dailyFee(dailyFee).build();

            vehicleRepository.save(vehicle);

            // Tworzę parametry do pojazdu
            Optional<VehicleParameters> searchedVehicleParameters = vehicleParametersRepository.findById(vehicle.getId()); //UWAGA
            if (!searchedVehicleParameters.isPresent()) {
                VehicleParameters vehicleParameters = VehicleParameters.builder()
                        .vehicle(vehicle) // UWAGA MOŻE SIĘ WYPIERDOLIC
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
//        String country, String city, String adres, String phone, String vehicleStatCode, Boolean available
//        Location location = Location.builder()
//                .country(country)
//                .city(city)
//                .adres(adres)
//                .phone(phone).build();
//        locationRepository.save(location);
//
//
//
//        Optional<VehicleStatus> searchVehicleStatus = vehicleStatusRepository.findByVehicleStatCode(vehicleStatCode);
//        if (!searchVehicleStatus.isPresent()) {
//            VehicleStatus vehicleStatus = VehicleStatus.builder()
//                    .vehicleStatCode(vehicleStatCode)
//                    .available(available).build();
//            vehicleStatusRepository.save(vehicleStatus);
//        }

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

    private void addLocation(String country, String city, String adres, String phone) {
//        Optional<Location> searchLocation = locationRepository.;
//        if (!searchLocation.isPresent()) {
        Location location = Location.builder()
                .country(country)
                .city(city)
                .adres(adres)
                .phone(phone).build();
        locationRepository.save(location);
    }

    private void addVehcileStatus(String vehicleStatCode, Boolean available) {
        Optional<VehicleStatus> searchVehicleStatus = vehicleStatusRepository.findByVehicleStatCode(vehicleStatCode);
        if (!searchVehicleStatus.isPresent()) {
            VehicleStatus vehicleStatus = VehicleStatus.builder()
                    .vehicleStatCode(vehicleStatCode)
                    .available(available).build();
            vehicleStatusRepository.save(vehicleStatus);
        }
    }


}
