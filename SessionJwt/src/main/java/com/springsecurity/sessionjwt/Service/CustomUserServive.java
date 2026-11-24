package com.springsecurity.sessionjwt.Service;

import com.springsecurity.sessionjwt.Entity.CustomDetails;
import com.springsecurity.sessionjwt.Entity.EmployesEntity;
import com.springsecurity.sessionjwt.Repository.EmployesRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserServive implements UserDetailsService {

    private EmployesRepository  employesRepository;

    CustomUserServive(EmployesRepository employesRepository) {
        this.employesRepository = employesRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

         EmployesEntity employesEntity= employesRepository.findByEmployeName(username).get();

         return new CustomDetails(employesEntity);
    }
}
