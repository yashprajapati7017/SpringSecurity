package com.springsecurity.sessionjwt.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.naming.Name;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity

public class EmployesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeId;
    @Column(nullable = false)
    private String employeName;
    @Column(nullable = false, unique = true)
    private String employeEmail;
    @Column(nullable = false)
    private String employePhone;
    @Column(nullable = false)
    private String password;
    @ManyToMany
    @JoinTable(name = "roleId",
    joinColumns = @JoinColumn(name = "Employes_id"),
    inverseJoinColumns = @JoinColumn(name="role_id")
    )
    private Set<EmployeRole> employeRole=new HashSet<>();

}
