package com.akshat14714.stockcalculator.common.utils;

import com.akshat14714.stockcalculator.common.dtos.LatLong;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class DistanceUtils {

    public static double haversineDistanceBwPoints(LatLong point1, LatLong point2) {

        double lat1 = Math.toRadians(point1.getLatitude());
        double long1 = Math.toRadians(point1.getLongitude());
        double lat2 = Math.toRadians(point2.getLatitude());
        double long2 = Math.toRadians(point2.getLongitude());

        double dlat = lat1 - lat2;
        double dlong = long1 - long2;

        double ans = Math.pow(Math.sin(dlat / 2), 2) + Math.pow(Math.sin(dlong / 2), 2) * Math.cos(lat1) * Math.cos(lat2);

        double rad = 6371;
        double c = 2 * Math.asin(Math.sqrt(ans));
        return rad * c * 1000;
    }

    public static LatLong getPointBetweenPointsFromDistance(LatLong point1, LatLong point2, double distanceFromPoint1) {
        if (point1.equals(point2)) {
            return point1;
        }

        double distanceBwPoints = haversineDistanceBwPoints(point1, point2);
        double distanceFromPoint2 = distanceBwPoints - distanceFromPoint1;
        double latitude = ((point1.getLatitude() * distanceFromPoint2) + (point2.getLatitude() * distanceFromPoint1)) / distanceBwPoints;
        double longitude = ((point1.getLongitude() * distanceFromPoint2) + (point2.getLongitude() * distanceFromPoint1)) / distanceBwPoints;
        return new LatLong(latitude, longitude);
    }
}
