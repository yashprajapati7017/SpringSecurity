package com.springsecurity.sessionjwt.Controller;

import com.springsecurity.sessionjwt.Entity.EmployeRole;
import com.springsecurity.sessionjwt.Service.RoleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    private RoleService roleService;

    RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping("/role")
    public EmployeRole create(@RequestBody EmployeRole employeRole) {
        return roleService.create(employeRole);
    }

}
