package com.springsecurity.sessionjwt.Entity;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class CustomDetails implements UserDetails {

    private EmployesEntity employesEntity;

    public CustomDetails(EmployesEntity employesEntity) {
        this.employesEntity = employesEntity;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return employesEntity.getEmployeRole().stream().map(employeRole ->
                new SimpleGrantedAuthority(employeRole.getRoleName())).toList();

    }

    @Override
    public @Nullable String getPassword() {
        return employesEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return employesEntity.getEmployeName();
    }
}
