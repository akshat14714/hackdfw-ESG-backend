package com.akshat14714.stockcalculator.common.dtos;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Stocks {

    private String name;

    private int esg;

    private double stockReturn;

    private int incentive;

    private double price;
}
