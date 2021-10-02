package com.akshat14714.stockcalculator.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserTable {

    @Id
    @Column(name = "userid")
    private String userid;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "incentive")
    private int incentive;
}
