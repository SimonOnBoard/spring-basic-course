package com.itis.kpfu.education.simononboard.spring.basics.services.impletentations;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
 
    @Override
    public Optional<String> getCurrentAuditor() {
        SecurityContext securityContext = SecurityContextHolder.getContext();
        if(securityContext.getAuthentication() != null){
            return Optional.of(securityContext.getAuthentication().getDetails().toString());
        }
        return Optional.empty();
    }

}