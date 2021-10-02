package com.akshat14714.stockcalculator.controllers.impl;

import com.akshat14714.stockcalculator.common.CommonConstants;
import com.akshat14714.stockcalculator.common.dtos.response.DirectionResponse;
import com.akshat14714.stockcalculator.common.dtos.request.GoogleDirectionRequest;
import com.akshat14714.stockcalculator.common.dtos.response.GoogleDirectionResponse;
import com.akshat14714.stockcalculator.common.dtos.LatLong;
import com.akshat14714.stockcalculator.common.dtos.exception.GenericException;
import com.akshat14714.stockcalculator.common.dtos.exception.GenericExceptionList;
import com.akshat14714.stockcalculator.controllers.DirectionController;
import com.akshat14714.stockcalculator.domain.webclients.GoogleClient;
import com.akshat14714.stockcalculator.services.utils.MarkersUtil;
import com.akshat14714.stockcalculator.services.utils.RouteUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class DirectionControllerImpl implements DirectionController {

    @Autowired
    GoogleClient googleClient;

    @Autowired
    RouteUtil routeUtil;

    @Autowired
    MarkersUtil markersUtil;

    @Override
    public DirectionResponse getDirectionsFromOriginToDestination(LatLong origin, LatLong destination, String mode) {
        if (origin==null || origin.getLatitude()==null || origin.getLongitude()==null ||
                destination==null || destination.getLatitude()==null || destination.getLongitude()==null ||
                mode==null) {
            log.error("Invalid Request. One of origin, destination or mode is null.");
            throw new GenericException(GenericExceptionList.BAD_REQUEST.name());
        }
        if (!CommonConstants.travelModes.contains(mode)) {
            log.error("Invalid travel mode used to call the API: {}", mode);
            throw new GenericException(GenericExceptionList.INVALID_TRAVEL_MODE.name());
        }


        GoogleDirectionRequest request =  GoogleDirectionRequest.builder().origin(origin).destination(destination).mode(mode).build();

        GoogleDirectionResponse googleDirectionResponse = googleClient.getGoogleDirectionResponse(request);
        log.info("Google Response : {}", googleDirectionResponse.toString());

        DirectionResponse response = new DirectionResponse();

//        if (googleDirectionResponse!=null && googleDirectionResponse.getRoutes()!=null && googleDirectionResponse.getRoutes().size()>0) {
//            List<LatLng> polylinePoints = routeUtil.getDecodedPolylinePoints(googleDirectionResponse.getRoutes().get(0));
//            log.info("Polyline Points : {}", polylinePoints.toString());
//            List<LatLong> markers = markersUtil.getMarkersOnRoute(polylinePoints, origin, destination);
//            response.setMarkers(markers);
//        }

        log.info("Marker String: \n" + response.markerString());

        return response;
    }
}
