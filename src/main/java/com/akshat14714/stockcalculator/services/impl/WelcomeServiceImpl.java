package com.akshat14714.stockcalculator.services.impl;

import com.akshat14714.stockcalculator.services.WelcomeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class WelcomeServiceImpl implements WelcomeService {

    @Override
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity welcomeToSpring() {
        System.out.println("Welcome to Spring!");
        return ResponseEntity.ok().body("Welcome to Spring!");
    }
}
