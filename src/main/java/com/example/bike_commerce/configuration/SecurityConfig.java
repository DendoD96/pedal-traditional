package com.example.bike_commerce.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //    FOR CUSTOMERS
//    @Configuration
////    @Order(1)
//    public static class App1ConfigurationAdapter {
    @Bean
    public UserDetailsService customersDetailsService() {
        return new UserInfoUserDetailsService();
    }

    @Bean
    public AuthenticationProvider customersAuthenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(customersDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain customersSecurityFilterChain(HttpSecurity http) throws Exception {
        return
                http
                        .csrf().disable()
                        .authorizeHttpRequests()
                        .requestMatchers("/", "/login", "/contact-support", "/signup","/employees/login").permitAll()
                        .and()
                        .authorizeHttpRequests()
                        .requestMatchers("/dashboard/**").authenticated()
                        .and()
                        .formLogin()
                        .loginPage("/login")
                        .permitAll()
                        .and().build();
    }
//    }

    //    FOR EMPLOYEES
//    @Configuration
//    @Order(2)
//    public static class App2ConfigurationAdapter {
//        @Bean
//        public SecurityFilterChain employeesSecurityFilterChain(HttpSecurity http) throws Exception {
//            return http
//                    .securityMatcher("/dashboard/**")
//                    .authorizeHttpRequests()
//                    .requestMatchers("/employees/login").permitAll()
//                    .and()
//                    .authorizeHttpRequests()
//                    .requestMatchers("/dashboard/**").authenticated()
//                    .and()
//                    .formLogin()
//                    .loginPage("/employees/login")
//                    .permitAll()
//                    .and().build();
//        }
//
//        @Bean
//        public UserDetailsService employeesDetailsService() {
//            return new UserInfoUserDetailsService();
//        }
//
//        @Bean
//        public AuthenticationProvider employeesAuthenticationProvider() {
//            DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//            authenticationProvider.setUserDetailsService(employeesDetailsService());
//            authenticationProvider.setPasswordEncoder(passwordEncoder());
//            return authenticationProvider;
//        }
//    }
}
