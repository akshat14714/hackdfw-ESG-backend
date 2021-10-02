package com.akshat14714.stockcalculator.services.utils.impl;

import com.akshat14714.stockcalculator.common.dtos.Leg;
import com.akshat14714.stockcalculator.common.dtos.Route;
import com.akshat14714.stockcalculator.common.dtos.Step;
import com.akshat14714.stockcalculator.common.dtos.exception.GenericException;
import com.akshat14714.stockcalculator.common.dtos.exception.GenericExceptionList;
import com.akshat14714.stockcalculator.services.utils.RouteUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@Slf4j
public class RouteUtilImpl implements RouteUtil {

//    @Override
//    public List<LatLng> getDecodedPolylinePoints(Route route) {
//        if (route==null || route.getLegs()==null || route.getLegs().size()==0) {
//            return null;
//        }
//
//        List<Leg> legs = route.getLegs();
//        List<Step> steps = new ArrayList<>();
//
//        for (Leg leg : legs) {
//            if (leg.getSteps() != null) {
//                steps.addAll(leg.getSteps());
//            }
//        }
//
//        List<LatLng> polylinePoints = new ArrayList<>();
//        for (Step step : steps) {
//            try {
//                polylinePoints.addAll(PolylineEncoding.decode(step.getPolyline().getPoints()));
//            } catch (Exception e) {
//                log.error("Error while decoding polylines: {}", Arrays.toString(e.getStackTrace()));
//                throw new GenericException(GenericExceptionList.POLYLINE_DECODING_ERROR.name());
//            }
//        }
//
//        return polylinePoints;
//    }
}
