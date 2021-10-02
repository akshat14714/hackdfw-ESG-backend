package com.akshat14714.stockcalculator.common.dtos.request;

import com.akshat14714.stockcalculator.common.dtos.LatLong;
import lombok.Data;

@Data
public class DirectionRequest {

    private LatLong origin;

    private LatLong destination;
}
