package com.pact.rentcar.service;

import com.pact.rentcar.model.AppUser;
import com.pact.rentcar.model.dto.request.RegisterUserRequest;
import com.pact.rentcar.repository.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AppUserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AppUserRepository appUserRepository;
    @Autowired
    private UserRoleService userRoleService;

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
}
