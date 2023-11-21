package com.kafkaStudy.ndj.domain.stock.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Stock {
    private String symbol;
    private double price;
}

