package com.akshat14714.stockcalculator.common.dtos.response;

import com.akshat14714.stockcalculator.common.dtos.LatLong;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class DirectionResponse {

    List<LatLong> markers;

    public String markerString() {
        String newLine = System.getProperty("line.separator");
        String markerStr = "";
        if (this.markers == null) {
            return markerStr;
        }
        for (LatLong marker : markers) {
            markerStr = markerStr.concat(marker.latLongToString() + ",").concat(newLine);
        }
        return markerStr;
    }
}
