package com.akshat14714.stockcalculator.common.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GeocodedWaypoint {

    @JsonProperty("geocoder_status")
    private String geocoderStatus;

    @JsonProperty("place_id")
    private String placeId;

    List<String> types;
}
