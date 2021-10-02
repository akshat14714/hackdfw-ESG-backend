package com.akshat14714.stockcalculator.controllers.impl;

import com.akshat14714.stockcalculator.common.CommonConstants;
import com.akshat14714.stockcalculator.common.dtos.Stocks;
import com.akshat14714.stockcalculator.common.dtos.User;
import com.akshat14714.stockcalculator.common.dtos.exception.GenericException;
import com.akshat14714.stockcalculator.common.dtos.exception.GenericExceptionList;
import com.akshat14714.stockcalculator.common.dtos.response.UserProfileResponse;
import com.akshat14714.stockcalculator.controllers.UserController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class UserControllerImpl implements UserController {

    @Override
    public UserProfileResponse getUserProfileFromId(String email) {
        UserProfileResponse response = new UserProfileResponse(email);

        response.setUserName("Akshat");
        response.setEmail(email);

        return response;
    }

    @Override
    public boolean addUserInvestment(String email, List<Stocks> stocks) {

//        User user = getUserFromEmail(email);
        User user = new User();

        user.setEmail(email);

//        int incentive = user.getIncentive();
        int incentive = 0;

        for (Stocks stock : stocks) {
            incentive += stock.getIncentive();
        }
        user.setIncentive(incentive);

        log.info("Incentive: " + incentive);

        return true;
    }
}
