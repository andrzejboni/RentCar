package com.pact.rentcar.component;


import com.pact.rentcar.configuration.SecurityConfiguration;
import com.pact.rentcar.model.AppUser;
import com.pact.rentcar.model.UserRole;
import com.pact.rentcar.repository.AppUserRepository;
import com.pact.rentcar.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

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


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // stworzenie uzytkownikow
        // stowrzenie podstawowych uprawnien

        createInitialRoles();
        createInitialUsers();

    }

    private void createInitialUsers() {
        addUser("admin", "admin", "Andrzej", "PinkFloyd", "888777555", "ROLE_USER", "ROLE_ADMIN");
        addUser("user", "user", "Roger", "Waters", "333000888", "ROLE_USER");
    }

    private void addUser(String username, String password, String firstName, String lastName, String phone, String... roles) {
        Set<UserRole> userRoles = new HashSet<>();  // towrzymy niepowtarzalnego seta
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
