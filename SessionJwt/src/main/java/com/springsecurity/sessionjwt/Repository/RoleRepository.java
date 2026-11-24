package com.springsecurity.sessionjwt.Repository;

import com.springsecurity.sessionjwt.Entity.EmployeRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<EmployeRole,Integer> {

    Optional<EmployeRole> findByRoleName(String roleName);

}
