package com.akshat14714.stockcalculator.controllers;

import com.akshat14714.stockcalculator.common.dtos.response.DirectionResponse;
import com.akshat14714.stockcalculator.common.dtos.LatLong;

public interface DirectionController {

    DirectionResponse getDirectionsFromOriginToDestination(LatLong origin, LatLong destination, String mode);
}
