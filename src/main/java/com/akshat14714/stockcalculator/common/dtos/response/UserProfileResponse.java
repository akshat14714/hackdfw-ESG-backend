package com.akshat14714.stockcalculator.common.dtos.response;

import com.akshat14714.stockcalculator.common.dtos.UserStocks;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class UserProfileResponse {

    private String userName;

    private List<UserStocks> stocks;
}
