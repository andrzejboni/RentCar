package com.pact.rentcar.model.dto.request;

import lombok.Data;

@Data
public class RegisterUserRequest { // 04 2:36
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String phone;
}
