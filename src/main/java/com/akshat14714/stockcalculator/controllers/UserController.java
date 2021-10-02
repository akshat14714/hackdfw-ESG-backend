package com.akshat14714.stockcalculator.controllers;

import com.akshat14714.stockcalculator.common.dtos.Stocks;
import com.akshat14714.stockcalculator.common.dtos.response.UserProfileResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserController {

    UserProfileResponse getUserProfileFromId(String email);

    boolean addUserInvestment(String email, List<Stocks> stocks);
}
