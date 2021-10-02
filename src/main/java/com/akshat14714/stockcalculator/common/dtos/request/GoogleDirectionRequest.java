package com.akshat14714.stockcalculator.common.dtos.request;

import com.akshat14714.stockcalculator.common.dtos.LatLong;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Builder
public class GoogleDirectionRequest {

    private LatLong origin;

    private LatLong destination;

    private String mode;
}
