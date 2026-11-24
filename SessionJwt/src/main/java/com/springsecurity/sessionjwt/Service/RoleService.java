package com.springsecurity.sessionjwt.Service;

import com.springsecurity.sessionjwt.Entity.EmployeRole;
import com.springsecurity.sessionjwt.Repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public EmployeRole create(EmployeRole employeRole) {
        roleRepository.save(employeRole);
        return employeRole;
    }

}
