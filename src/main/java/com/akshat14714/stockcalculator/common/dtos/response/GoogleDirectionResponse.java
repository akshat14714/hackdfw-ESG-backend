package com.akshat14714.stockcalculator.common.dtos.response;

import com.akshat14714.stockcalculator.common.dtos.GeocodedWaypoint;
import com.akshat14714.stockcalculator.common.dtos.Route;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class GoogleDirectionResponse {

    @JsonProperty("geocoded_waypoints")
    private List<GeocodedWaypoint> geocodedWaypoints;

    List<Route> routes;

    private String status;
}
