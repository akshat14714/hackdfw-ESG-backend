package com.akshat14714.stockcalculator.domain.webclients;

import com.akshat14714.stockcalculator.common.dtos.request.GoogleDirectionRequest;
import com.akshat14714.stockcalculator.common.dtos.response.GoogleDirectionResponse;

public interface GoogleClient {

    GoogleDirectionResponse getGoogleDirectionResponse(GoogleDirectionRequest googleDirectionRequest);
}
