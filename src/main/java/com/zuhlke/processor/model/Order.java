package com.zuhlke.processor.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class Order {

    private int id;
    private String orderId;
    private LocalDate orderDate;
    private LocalDate shipDate;
    private String shipMode;
    private String customerId;
    private String customerName;
    private String segment;
    private String country;
    private String city;
    private String state;
    private String postalCode;
    private String region;
    private String productId;
    private String category;
    private String subCategory;
    private String productName;
    private String sales;
    private int quantity;
    private BigDecimal discount;
    private BigDecimal profit;


}
