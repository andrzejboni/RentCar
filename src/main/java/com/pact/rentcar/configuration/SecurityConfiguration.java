package com.pact.rentcar.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserDetailsService appUserAuthenticationService; // powiązujemy z service

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .anyRequest()
                .permitAll();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(){
        DaoAuthenticationProvider provier = new DaoAuthenticationProvider();
        provier.setPasswordEncoder(passwordEncoder);
        provier.setUserDetailsService(appUserAuthenticationService); // podajemy klasę w której jest odpowiwedzialne logowanie
        return provier;
    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception { // 02  12:20
        auth.authenticationProvider(daoAuthenticationProvider());
    }





}
