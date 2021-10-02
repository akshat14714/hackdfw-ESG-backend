package com.akshat14714.stockcalculator.common.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Leg {

    private Distance distance;

    private Duration duration;

    @JsonProperty("start_address")
    private String startAddress;

    @JsonProperty("start_location")
    private LatLong startLocation;

    @JsonProperty("end_address")
    private String endAddress;

    @JsonProperty("end_location")
    private LatLong endLocation;

    List<Step> steps;
}
