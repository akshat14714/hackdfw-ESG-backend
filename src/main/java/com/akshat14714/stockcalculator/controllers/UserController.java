package com.akshat14714.stockcalculator.controllers;

import com.akshat14714.stockcalculator.common.dtos.StockInvestment;
import com.akshat14714.stockcalculator.common.dtos.request.StockInvestmentRequest;
import com.akshat14714.stockcalculator.common.dtos.response.UserProfileResponse;

import java.util.List;

public interface UserController {

    UserProfileResponse getUserProfileFromId(String email);

    boolean addUserInvestment(String email, List<StockInvestmentRequest> stocks);
}
