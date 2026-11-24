package com.springsecurity.sessionjwt.Dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class EmployesRequestDto {

    private String username;
    private String password;
    private String email;
    private String phoneNumber;

}
