package com.pact.rentcar.service;

import com.pact.rentcar.model.AppUser;
import com.pact.rentcar.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Adnotacja używana jako stereotyp do definiowania warstwy usług.Spring widząc że klasa ma ustawioną powyższa adnotację wie że z
// danej klasy musi utworzyć beana i nadać mu id takie jak nazwa klasy tylko małą literą.Taki bean może być wstrzykiwany adnotacyjnie
// czy też xml-owo do innych beanów.Omijamy w ten sposób potrzebę definiowania Bean w konfiguracji xml

@Service
public class AppUserAuthenticationService implements UserDetailsService {

// film 02 - 6:16
    @Autowired
    private AppUserRepository appUserRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<AppUser> appUserOptional = appUserRepository.findByUsername(username);
        if (appUserOptional.isPresent()) {
            AppUser appUser = appUserOptional.get();

            List<String> roles = appUser.getRoles()
                    .stream()
                    .map(userRole -> userRole.getName().replace("ROLE_", ""))
                    .collect(Collectors.toList());


            return User.builder()           /// TUTAJ ZAMAIST USER MOZE BYC APPUSER HALO HALO@@!!
                    .username(appUser.getUsername())
                    .password(appUser.getPassword())
                    .roles(roles.toArray(new String[roles.size()])) // przenosimy z listy do tablicy
                    .build();
        }
        throw new UsernameNotFoundException("Username could not be found.");
    }


    public Optional<AppUser> getLoggedInUser(){
        if (SecurityContextHolder.getContext().getAuthentication() == null ||
                SecurityContextHolder.getContext().getAuthentication().getPrincipal() == null ||
                !SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            // nie jesteśmy zalogowani
            return Optional.empty();
        }

        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof User) {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return appUserRepository.findByUsername(user.getUsername());
        }
        return Optional.empty();
    }

}
