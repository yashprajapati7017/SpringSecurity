package com.springsecurity.sessionjwt.Cofiguration;

import com.springsecurity.sessionjwt.Service.CustomUserServive;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class BeanDeclear {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(CustomUserServive custemUserServive,
                                                               PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider(custemUserServive);
        provider.setPasswordEncoder(passwordEncoder);
        return provider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   DaoAuthenticationProvider daoAuthenticationProvider)
            throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authenticationProvider(daoAuthenticationProvider)
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults())
                .authorizeHttpRequests
                        (auth->auth.requestMatchers("/create")
                        .permitAll().anyRequest().authenticated());
        return http.build();
    }

}
