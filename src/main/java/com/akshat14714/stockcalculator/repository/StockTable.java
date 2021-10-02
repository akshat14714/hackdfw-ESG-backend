package com.akshat14714.stockcalculator.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class StockTable {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "stock_id")
    private int stockId;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total_purchase_price")
    private double totalPurchasePrice;

    @Column(name = "incentive")
    private int incentive;
}