package com.akshat14714.stockcalculator.common.dtos;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

    private int userId;

    private String name;

    private int incentive;
}
