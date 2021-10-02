package com.akshat14714.stockcalculator.services;

import org.springframework.http.ResponseEntity;

public interface UserService {

    ResponseEntity getUserProfile(int id);
}
