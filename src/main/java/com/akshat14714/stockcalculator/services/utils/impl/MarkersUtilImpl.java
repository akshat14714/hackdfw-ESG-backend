package com.akshat14714.stockcalculator.services.utils.impl;

import com.akshat14714.stockcalculator.common.dtos.LatLong;
import com.akshat14714.stockcalculator.common.utils.DistanceUtils;
import com.akshat14714.stockcalculator.services.utils.MarkersUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

@Component
@Slf4j
public class MarkersUtilImpl implements MarkersUtil {

    @Value("${distance.between.markers}")
    private double MARKER_DISTANCE;

//    @Override
//    public List<LatLong> getMarkersOnRoute(List<LatLng> polylinePoints, LatLong origin, LatLong destination) {
//
//        List<LatLong> markers = new ArrayList<>();
//        Queue<LatLng> pointsList = new LinkedList<>(polylinePoints);
//
//        LatLong currPoint = new LatLong();
//        LatLong prevPoint = new LatLong(origin.getLatitude(), origin.getLongitude());
//        double prevDistance = 0.0;
//        double distance;
//
//        while (!pointsList.isEmpty()) {
//            LatLng point = pointsList.poll();
//            currPoint.setLatitude(point.lat);
//            currPoint.setLongitude(point.lng);
//            distance = DistanceUtils.haversineDistanceBwPoints(prevPoint, currPoint);
//
//            if (distance + prevDistance - MARKER_DISTANCE >= 0) {
//                double distanceOfPrevMarkerFromCurr = distance + prevDistance;
//                double distanceOfMarkerFromPrev = MARKER_DISTANCE - prevDistance;
//                long numMarkers = Math.round(distanceOfPrevMarkerFromCurr / MARKER_DISTANCE);
//
//                while (numMarkers > 0) {
//                    LatLong marker = DistanceUtils.getPointBetweenPointsFromDistance(prevPoint, currPoint, distanceOfMarkerFromPrev);
//                    markers.add(marker);
//                    distanceOfPrevMarkerFromCurr -= MARKER_DISTANCE;
//                    distanceOfMarkerFromPrev += MARKER_DISTANCE;
//                    numMarkers--;
//                }
//
//                prevDistance = distanceOfPrevMarkerFromCurr;
//
//            } else {
//                prevDistance += distance;
//            }
//
//            prevPoint.setLatitude(currPoint.getLatitude());
//            prevPoint.setLongitude(currPoint.getLongitude());
//        }
//
//        return markers;
//    }
}
