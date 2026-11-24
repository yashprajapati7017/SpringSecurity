package com.springsecurity.sessionjwt.Repository;

import com.springsecurity.sessionjwt.Entity.EmployesEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployesRepository extends JpaRepository<EmployesEntity,Integer> {

    @EntityGraph(attributePaths = "employeRole")
    Optional<EmployesEntity> findByEmployeName(String EmployeName);
}
