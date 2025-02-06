package com.ec.ecommerce_base_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Désactiver CSRF (utile pour API REST)
                .csrf(csrf -> csrf.disable())

                // Autoriser l'affichage des iframes (ex. console H2)
                .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))

                // Configuration des autorisations
                .authorizeHttpRequests(auth -> auth
                        // Autoriser l'accès à la console H2 sans authentification
                        .requestMatchers("/h2-console/**").permitAll()

                        // Autoriser certaines routes sans authentification (ex: login, register)
                        .requestMatchers("/public/**").permitAll()

                        // Exiger une authentification pour tout le reste
                        .anyRequest().authenticated()
                )

                // Activer l'authentification Basic
                .httpBasic(withDefaults())

                // Désactiver la gestion de session (API REST stateless)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }


}