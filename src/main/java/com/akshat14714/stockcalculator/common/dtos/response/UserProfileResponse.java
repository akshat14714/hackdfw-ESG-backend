package com.akshat14714.stockcalculator.common.dtos.response;

import com.akshat14714.stockcalculator.common.dtos.UserStocks;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class UserProfileResponse {

    private String userName;

    private String email;

    private List<UserStocks> stocks;

    public UserProfileResponse() {
    }

    public UserProfileResponse(String email) {
        this.email = email;
    }
}
