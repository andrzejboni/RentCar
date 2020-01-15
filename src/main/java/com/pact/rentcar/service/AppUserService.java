package com.pact.rentcar.service;

import com.pact.rentcar.model.AppUser;
import com.pact.rentcar.model.Booking;
import com.pact.rentcar.model.dto.request.RegisterUserRequest;
import com.pact.rentcar.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppUserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private UserRoleService userRoleService;

    public String getLoggedUsername(){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String currentUserName = authentication.getName();
            return currentUserName;
        }

        return null;  // TODO OGARNĄC TO @@@@@@@@@@@@@
    }



    public Optional<AppUser> register(RegisterUserRequest registerUserRequest) {
        Optional<AppUser> optionalAppUser = appUserRepository.findByUsername(registerUserRequest.getUsername());
        if (optionalAppUser.isPresent()) {
            //nie moge zareejestrowac
            return Optional.empty();
        }

        AppUser appUser = new AppUser();
        appUser.setUsername(registerUserRequest.getUsername());
        appUser.setPassword(passwordEncoder.encode(registerUserRequest.getPassword()));
        appUser.setFirstName(registerUserRequest.getFirstName());
        appUser.setLastName(registerUserRequest.getLastName());
        appUser.setPhone(registerUserRequest.getPhone());

        appUser.setRoles(userRoleService.getDefaultUserRoles());

        return Optional.of(appUserRepository.save(appUser));
    }

//    public Optional<AppUser> findUserByUsername(String username) {
//        Optional<AppUser> optionalAppUser = appUserRepository.findByUsername(username);
//        if (optionalAppUser.isPresent()) {
//
//            return Optional.empty();
//        }
//        return optionalAppUser;
//    }


    public AppUser findUserByUsername(String username){
        List<AppUser> appUserList = appUserRepository.findAll();

        for (int i = 0; i < appUserList.size(); i++) {
            if (appUserList.get(i).getUsername().equals(username)) {
                return appUserList.get(i);
            }
        }
        return null; // TODO OGARNĄC TO @@@@@@@@@@@@@
    }




}
