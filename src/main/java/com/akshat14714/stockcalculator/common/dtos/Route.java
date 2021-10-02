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
public class Route {

    @JsonProperty("summary")
    private String summary;

    @JsonProperty("warnings")
    private List<String> warnings;

    @JsonProperty("waypoint_order")
    private List<Object> waypointOrder;

    List<Leg> legs;

    @JsonProperty("overview_polyline")
    private Polyline overviewPolyline;
}
