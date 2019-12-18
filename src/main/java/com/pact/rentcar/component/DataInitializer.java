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
import java.util.*;

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

        // stowrzenie podstawowych uprawnien
        createInitialRoles();

        // stworzenie uzytkownikow
        createInitialUsers();

        // tworzenie statusów pojazdów
        createInitialVehicleStatus();

        // stworzenie pojazdów
        createInitialVehicles();
    }


    private void createInitialUsers() {
        addUser("admin", "admin", "Andrzej", "PinkFloyd", "888777555", "ROLE_USER", "ROLE_ADMIN");
        addUser("user", "user", "Roger", "Waters", "333000888", "ROLE_USER");
    }

    private void createInitialVehicles() {

        Optional<VehicleStatus> vehicleStatusOptional = vehicleStatusRepository.findByVehicleStatCode("AVI");
        if (vehicleStatusOptional.isPresent()) {
            VehicleStatus aviVehicleStatus = vehicleStatusOptional.get();


        addVehicle("GD1111", "Honda", "Civic", 120.0, "Sedan", 1999, "LPG",
                90, "auto", 1, 3,
                5, "Yellow", 1, "", "Lorem ipsum", "Poland", "Gdansk", "Pozbawiona 17", "333 333 333", aviVehicleStatus);
        addVehicle("GD2222", "Mazda", "2", 130.0, "Hatchback", 2006, "Petrol",
                75, "manual", 1, 5,
                7, "Red", 0, "", "Fast as red arrow", "Poland", "Gdynia", "Aksamitna 1", "667 222 333", aviVehicleStatus);
        addVehicle("GD3333", "Volvo", "S90", 300.0, "Sedan", 2019, "Petrol",
                270, "auto", 0, 5,
                5, "Gold", 1, "", "Lorem ipsum", "Poland", "Sopot", "Typowa 7", "456 333 555",aviVehicleStatus);
        addVehicle("GD4444", "Toyota", "Prius", 170.0, "Sedan", 2016, "Hybrid",
                70, "auto", 1, 3,
                5, "Silver", 1, "", "Lorem ipsum", "Poland", "Wejherowo", "Mroczna 88", "222 333 333",aviVehicleStatus);
        addVehicle("GD5555", "Tesla", "Model 3", 280.0, "Sedan", 2018, "Electric",
                210, "auto", 1, 5,
                5, "Black", 1, "", "Lorem ipsum", "Poland", "Wejherowo", "Mroczna 88", "222 333 333", aviVehicleStatus);
        addVehicle("GD1234", "Hyundai", "i20", 369.4, "Hatchback", 2017, "Petrol",
                85, "manual", 1, 5,
                5, "RedPassion", 1, "", "Lorem ipsum", "Poland", "Rumia", "Czysta 33", "123 333 333", aviVehicleStatus);

        }

    }


    private void createInitialVehicleStatus() {
        addVehicleStatus("AVI", true);
        addVehicleStatus("UAV", false);
    }

    private void addVehicle(String registration, String brand, String model, Double dailyFee, String bodytype, Integer productionYear, String fuelType, Integer power, String gearbox,
                            Integer frontWheelDrive, Integer doorsNumber, Integer seatsNumber, String color, Integer metallic, String photoName, String description
            , String country, String city, String adres, String phone, VehicleStatus vehicleStatus) {

        // Tworzę lokalizacje
        Location location = Location.builder()
                .country(country)
                .city(city)
                .adres(adres)
                .phone(phone).build();
        locationRepository.save(location);


        // Tworzę pojazd
        Optional<Vehicle> searchedVehicle = vehicleRepository.findVehicleByRegistration(registration);
        if (!searchedVehicle.isPresent()) {
            Vehicle vehicle = Vehicle.builder()
                    .registration(registration)
                    .brand(brand)
                    .model(model)
                    .dailyFee(dailyFee)
                    .location(location)
                    .vehicleStatus(vehicleStatus)
                    .build();
            vehicleRepository.save(vehicle);

            // Tworzę parametry do pojazdu
            Optional<VehicleParameters> searchedVehicleParameters = vehicleParametersRepository.findById(vehicle.getId());
            if (!searchedVehicleParameters.isPresent()) {
                VehicleParameters vehicleParameters = VehicleParameters.builder()
                        .id(vehicle.getId())
//                        .vehicle(vehicle)
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

    private void addVehicleStatus(String vehicleStatCode, Boolean available) {
        Optional<VehicleStatus> searchVehicleStatus = vehicleStatusRepository.findByVehicleStatCode(vehicleStatCode);
        if (!searchVehicleStatus.isPresent()) {
            VehicleStatus vehicleStatus = VehicleStatus.builder()
                    .vehicleStatCode(vehicleStatCode)
                    .available(available).build();
            vehicleStatusRepository.save(vehicleStatus);
        }
    }
}
