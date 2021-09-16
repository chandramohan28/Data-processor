package com.zuhlke.processor.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "STORE_ORDER")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ORDER_ID", nullable = false)
    private String orderId;

    @Column(name = "ORDER_DATE", nullable = false)
    private LocalDate orderDate;

    @Column(name = "SHIP_DATE", nullable = false)
    private LocalDate shipDate;

    @Column(name = "SHIP_MODE")
    private String shipMode;

    @Column(name = "QUANTITY", nullable = false)
    private Integer quantity;

    @Column(name = "DISCOUNT")
    private BigDecimal discount;

    @Column(name = "PROFIT", nullable = false)
    private BigDecimal profit;

    @Column(name = "PRODUCT_ID", nullable = false)
    private String productId;

    @Column(name = "CUSTOMER_NAME", nullable = false)
    private String customerName;

    @Column(name = "CATEGORY", nullable = false)
    private String category;

    @Column(name = "CUSTOMER_ID", nullable = false)
    private String customerId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

}
