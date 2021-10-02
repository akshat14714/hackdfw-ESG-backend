package com.akshat14714.stockcalculator.controllers.impl;

import com.akshat14714.stockcalculator.common.CommonConstants;
import com.akshat14714.stockcalculator.common.dtos.exception.GenericException;
import com.akshat14714.stockcalculator.common.dtos.exception.GenericExceptionList;
import com.akshat14714.stockcalculator.common.dtos.response.UserProfileResponse;
import com.akshat14714.stockcalculator.controllers.UserController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
}
