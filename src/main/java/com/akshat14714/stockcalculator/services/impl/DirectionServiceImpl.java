package com.akshat14714.stockcalculator.services.impl;

import com.akshat14714.stockcalculator.common.dtos.request.DirectionRequest;
import com.akshat14714.stockcalculator.common.dtos.response.DirectionResponse;
import com.akshat14714.stockcalculator.common.dtos.response.GenericResponse;
import com.akshat14714.stockcalculator.common.dtos.exception.GenericException;
import com.akshat14714.stockcalculator.controllers.DirectionController;
import com.akshat14714.stockcalculator.services.DirectionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Slf4j
@RestController
@RequestMapping("/directions")
public class DirectionServiceImpl implements DirectionService {

    @Autowired
    DirectionController directionController;

    @Override
    @RequestMapping(method = RequestMethod.GET, value = "{mode}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<GenericResponse> getDirections(@DefaultValue("driving") @PathVariable("mode")  String mode,
                                                         @RequestBody DirectionRequest request) {
        log.info("request : {}", request.toString());
        try {
            DirectionResponse response = directionController.getDirectionsFromOriginToDestination(request.getOrigin(), request.getDestination(), mode);
            GenericResponse gr = new GenericResponse(200, "success", null);
            gr.setData(response);
            return ResponseEntity.ok().body(gr);
        } catch (GenericException e) {
            GenericResponse gr = new GenericResponse(e.getResponse());
            return ResponseEntity.status(gr.getCode()).body(gr);
        } catch (Exception e) {
            log.error("Direction Service for request failed: {}", Arrays.toString(e.getStackTrace()));
            throw new GenericException(e);
        }
    }
}
