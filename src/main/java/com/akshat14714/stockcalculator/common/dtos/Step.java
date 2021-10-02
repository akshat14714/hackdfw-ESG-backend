package com.akshat14714.stockcalculator.common.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Step {

    private Distance distance;

    private Duration duration;

    @JsonProperty("start_location")
    private LatLong startLocation;

    @JsonProperty("end_location")
    private LatLong endLocation;

    @JsonProperty("travel_mode")
    private TravelMode travelMode;

    @JsonProperty("html_instructions")
    private String htmlInstructions;

    private Polyline polyline;
}
