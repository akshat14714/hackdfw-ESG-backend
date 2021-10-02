package com.akshat14714.stockcalculator.services;

import com.akshat14714.stockcalculator.common.dtos.request.DirectionRequest;
import org.springframework.http.ResponseEntity;

public interface DirectionService {

    ResponseEntity getDirections(String mode, DirectionRequest directionRequest);
}
