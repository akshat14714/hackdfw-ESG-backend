package com.akshat14714.stockcalculator.repository;

import com.akshat14714.stockcalculator.common.dtos.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
@Component
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT u FROM UserTable u WHERE u.email = ?1")
    User findUserByEmail(String email);
}