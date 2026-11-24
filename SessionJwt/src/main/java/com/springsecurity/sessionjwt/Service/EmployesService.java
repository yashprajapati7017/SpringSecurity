package com.springsecurity.sessionjwt.Service;

import com.springsecurity.sessionjwt.Dto.EmployesRequestDto;
import com.springsecurity.sessionjwt.Dto.EmployesResponceDto;
import com.springsecurity.sessionjwt.Entity.EmployeRole;
import com.springsecurity.sessionjwt.Entity.EmployesEntity;
import com.springsecurity.sessionjwt.Repository.EmployesRepository;
import com.springsecurity.sessionjwt.Repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployesService {

    private final EmployesRepository employesRepository;
    private final RoleRepository roleRepository;
    private  PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();




    public EmployesResponceDto Create(EmployesRequestDto employesRequestDto){
        EmployesEntity employesEntity = new EmployesEntity();
        employesEntity.setEmployeName(employesRequestDto.getUsername());
        employesEntity.setEmployeEmail(employesRequestDto.getEmail());
        employesEntity.setEmployePhone(employesRequestDto.getPhoneNumber());

        String Password=passwordEncoder.encode(employesRequestDto.getPassword());

        employesEntity.setPassword(Password);

        EmployeRole employesRole = new EmployeRole();
        employesRole=roleRepository.findByRoleName("backEndDeveloper").get();

        employesEntity.getEmployeRole().add(employesRole);

        employesRepository.save(employesEntity);

        EmployesResponceDto employesResponceDto = new EmployesResponceDto();
        employesResponceDto.setUsername(employesEntity.getEmployeName());
        employesResponceDto.setEmail(employesEntity.getEmployeEmail());
        employesResponceDto.setPhoneNumber(employesEntity.getEmployePhone());
        employesResponceDto.setMessage("data is save succesfully");

        return employesResponceDto;

    }

}
