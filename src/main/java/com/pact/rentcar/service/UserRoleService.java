package com.pact.rentcar.service;

import com.pact.rentcar.model.UserRole;
import com.pact.rentcar.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserRoleService {
    @Value("${rentcar.user.defaultRoles}")
    private String[] defaultRoles;

    @Autowired
    private UserRoleRepository userRoleRepository;

    public Set<UserRole> getDefaultUserRoles() {
        Set<UserRole> userRoles = new HashSet<>();
        for (String role : defaultRoles) { // dodajemy doń wszystkie role jakie tylko zostały stworzone(moze byc ich wiecej niz 1)
            Optional<UserRole> singleRole = userRoleRepository.findByName(role);
            if (singleRole.isPresent()) {
                userRoles.add(singleRole.get());
            }
        }

        return userRoles;
    }
}
