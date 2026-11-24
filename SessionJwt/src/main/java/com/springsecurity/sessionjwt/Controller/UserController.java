package com.springsecurity.sessionjwt.Controller;

import com.springsecurity.sessionjwt.Dto.EmployesRequestDto;
import com.springsecurity.sessionjwt.Dto.EmployesResponceDto;
import com.springsecurity.sessionjwt.Service.EmployesService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    private EmployesService  employesService;

    UserController(EmployesService employesService) {
        this.employesService = employesService;
    }

    @GetMapping("/hello")
    public String Hello() {
        return "Hello World";
    }

    @PostMapping("/create")
    public ResponseEntity<EmployesResponceDto> create(@RequestBody EmployesRequestDto  employesRequestDto) {

        EmployesResponceDto responceDto= employesService.Create(employesRequestDto);

        return ResponseEntity.status(HttpStatus.CREATED).body(responceDto);
    }

    @GetMapping("/token")
    public CsrfToken csrfToken(CsrfToken csrfToken) {
        return csrfToken;
    }

}
