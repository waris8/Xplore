package com.app.xplore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class AuditConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> {
            // Get the current authentication from the security context
            return Optional.ofNullable(SecurityContextHolder.getContext())
                    .map(SecurityContext::getAuthentication)
                    .filter(Authentication::isAuthenticated)
                    .map(authentication -> {
                        // If the principal is a UserDetails, return the username
                        if (authentication.getPrincipal() instanceof org.springframework.security.core.userdetails.UserDetails) {
                            return ((org.springframework.security.core.userdetails.UserDetails) authentication.getPrincipal()).getUsername();
                        }
                        // Otherwise, return the principal's string representation
                        return authentication.getName();
                    });
        };
    }
}
