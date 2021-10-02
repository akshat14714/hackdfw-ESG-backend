package com.akshat14714.stockcalculator.services.impl;

import com.akshat14714.stockcalculator.common.dtos.exception.GenericException;
import com.akshat14714.stockcalculator.common.dtos.request.UserProfileRequest;
import com.akshat14714.stockcalculator.common.dtos.response.GenericResponse;
import com.akshat14714.stockcalculator.common.dtos.response.UserProfileResponse;
import com.akshat14714.stockcalculator.controllers.UserController;
import com.akshat14714.stockcalculator.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserServiceImpl implements UserService {

    @Autowired
    UserController userController;

    @Override
    @RequestMapping(method = RequestMethod.GET, produces = "application/json", consumes = "application/json")
    public ResponseEntity getUserProfile(@RequestBody UserProfileRequest request) {
        log.info("request : {}", request.toString());
        try {
            UserProfileResponse response = userController.getUserProfileFromId(request.getEmail());
            GenericResponse gr = new GenericResponse(200, "success", null);
            gr.setData(response);
            return ResponseEntity.ok().body(gr);
        } catch (GenericException e) {
            GenericResponse gr = new GenericResponse(e.getResponse());
            return ResponseEntity.status(gr.getCode()).body(gr);
        } catch (Exception e) {
            log.error("Direction Service for request failed: {}", Arrays.toString(e.getStackTrace()));
            throw new GenericException(e);
        }
    }
}
