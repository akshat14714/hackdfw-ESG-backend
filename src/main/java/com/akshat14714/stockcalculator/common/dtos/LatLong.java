package com.akshat14714.stockcalculator.common.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.RoundingMode;
import java.text.DecimalFormat;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
public class LatLong {

    @JsonProperty("lat")
    private Double latitude;

    @JsonProperty("lng")
    private Double longitude;

    public String latLongToString() {
        StringBuilder stringBuilder = new StringBuilder();
        DecimalFormat df = new DecimalFormat("#.#######");
        df.setRoundingMode(RoundingMode.CEILING);
        stringBuilder.append(df.format(latitude)).append(",").append(df.format(longitude));
        return stringBuilder.toString();
    }
}
