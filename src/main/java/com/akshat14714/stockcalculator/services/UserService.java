package com.akshat14714.stockcalculator.services;

import com.akshat14714.stockcalculator.common.dtos.request.UserInvestmentRequest;
import com.akshat14714.stockcalculator.common.dtos.request.UserProfileRequest;
import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity getUserProfile(UserProfileRequest request);

    ResponseEntity getAddUserInvestment(UserInvestmentRequest request);
}
