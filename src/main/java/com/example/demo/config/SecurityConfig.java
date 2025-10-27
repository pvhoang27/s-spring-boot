package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())  // tắt CSRF (cho phép Postman gửi request)
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().permitAll()  // cho phép tất cả request
                )
                .formLogin(login -> login.disable()) // tắt form login
                .httpBasic(basic -> basic.disable()); // tắt basic auth
        return http.build();
    }
}
