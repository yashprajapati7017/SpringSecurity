package com.springsecurity.demo1;

import org.springframework.http.ResponseEntity;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("/method")
    public ResponseEntity<String> getMethod(){
        return ResponseEntity.ok("This is get method");
    }

    @PostMapping("/method")
    public ResponseEntity<String> Post(){
        return ResponseEntity.ok("This is post method");
    }

    @PutMapping("/methd")
    public ResponseEntity<String> put(){
        return ResponseEntity.ok("This is put method");
    }

    @GetMapping("/csrf")
    public CsrfToken csrfToken(CsrfToken csrfToken){
        return csrfToken;
    }

}
