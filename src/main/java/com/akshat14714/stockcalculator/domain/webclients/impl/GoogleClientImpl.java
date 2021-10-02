package com.akshat14714.stockcalculator.domain.webclients.impl;

import com.akshat14714.stockcalculator.common.dtos.request.GoogleDirectionRequest;
import com.akshat14714.stockcalculator.common.dtos.response.GoogleDirectionResponse;
import com.akshat14714.stockcalculator.common.dtos.exception.GenericException;
import com.akshat14714.stockcalculator.common.dtos.exception.GenericExceptionList;
import com.akshat14714.stockcalculator.domain.webclients.GoogleClient;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;

@Slf4j
@Component
public class GoogleClientImpl implements GoogleClient {

    @Autowired
    RestTemplate restTemplate;

    private static ObjectMapper objectMapper = new ObjectMapper();

//    @Value("${google.api.key}")
    private String GOOGLE_API_KEY;

//    @Value("${google.apis.host}")
    private String GOOGLE_API_HOST;

//    @Value("${google.maps.directions.endpoint}")
    private String GOOGLE_DIRECTION_ENDPOINT;

    private String getGoogleDirectionUrl() {
        String directionRequestUrl = GOOGLE_API_HOST + GOOGLE_DIRECTION_ENDPOINT;
        return directionRequestUrl;
    }

    @Override
    public GoogleDirectionResponse getGoogleDirectionResponse(GoogleDirectionRequest googleDirectionRequest) {
        String directionRequestUrl = getGoogleDirectionUrl();

        UriComponentsBuilder googleDirectionUri = UriComponentsBuilder.fromHttpUrl(directionRequestUrl)
                .queryParam("key", GOOGLE_API_KEY)
                .queryParam("origin", googleDirectionRequest.getOrigin().latLongToString())
                .queryParam("destination", googleDirectionRequest.getDestination().latLongToString())
                .queryParam("mode", googleDirectionRequest.getMode());

        GoogleDirectionResponse response = null;

        log.info("URI : {}", googleDirectionUri.toUriString());

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        HttpEntity entity = new HttpEntity(headers);

        try {
            HttpEntity<GoogleDirectionResponse> responseHttpEntity = restTemplate.exchange(googleDirectionUri.toUriString(), HttpMethod.GET, entity, GoogleDirectionResponse.class);
            response = responseHttpEntity.getBody();
        } catch (Exception e) {
            log.error("Call to Google Direction API failed: {}", Arrays.toString(e.getStackTrace()));
            throw new GenericException(GenericExceptionList.GOOGLE_CLIENT_ERROR.name());
        }

        return response;
    }
}
