package com.springsecurity.sessionjwt.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@Component
public class EmployesResponceDto {

    private String username;
    private String email;
    private String phoneNumber;
    private String message;
}
