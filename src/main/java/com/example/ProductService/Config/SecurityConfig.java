package com.example.ProductService.Config;

import com.example.ProductService.Filter.JwtAuthenticationFilter;
import jakarta.servlet.Filter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, JwtAuthenticationFilter jwtAuthenticationFilter) throws Exception {

        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/products/start").permitAll()
                        .requestMatchers("/products/get_products").permitAll()
                        .requestMatchers("/products/category/**").permitAll()
                        .requestMatchers("/products/add_products").permitAll()
                        .requestMatchers("/products/delete_product/**").permitAll()
                        .requestMatchers("/products/test/**").permitAll()
                        .requestMatchers("/products/total").permitAll()
                        .requestMatchers("/products/productgreaterthan/*").permitAll()
                        .requestMatchers("/products/productlessthan/*").permitAll()
                        .requestMatchers("/products/productbetween/*/*").permitAll()
                        .requestMatchers("/products/check-stock").permitAll()


                        .anyRequest().authenticated()
                )
                .addFilterBefore((Filter) jwtAuthenticationFilter, org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter.class).build();
    }
    }



