package com.zuhlke.processor.mapper;

import com.zuhlke.processor.entity.OrderEntity;
import com.zuhlke.processor.model.Order;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class OrderMapperTest {

    private OrderMapper orderMapper;

    @BeforeEach
    public void setUp() {
        orderMapper = new OrderMapper();
    }

    @Test
    @DisplayName("Verify if returns Order Entity list")
    public void should_Return_OrderEntity() {
        List<OrderEntity> entityList = orderMapper.mapList(populateOrders());
        assertThat(entityList).isNotEmpty();
        assertThat(entityList).extracting(OrderEntity::getOrderId)
                .containsOnly("1", "2");
        assertThat(entityList).extracting(OrderEntity::getOrderDate)
                .containsOnly(LocalDate.of(2012, 12, 12), LocalDate.of(2012, 12, 12));
        assertThat(entityList).extracting(OrderEntity::getShipDate)
                .containsOnly(LocalDate.of(2012, 12, 13), LocalDate.of(2012, 12, 13));
        assertThat(entityList).extracting(OrderEntity::getShipMode)
                .containsOnly("Postal", "Postal");
        assertThat(entityList).extracting(OrderEntity::getQuantity)
                .containsOnly(2, 4);
        assertThat(entityList).extracting(OrderEntity::getDiscount)
                .containsOnly(new BigDecimal("10.5"), new BigDecimal("1.5"));
        assertThat(entityList).extracting(OrderEntity::getProfit)
                .containsOnly(new BigDecimal("12"), new BigDecimal("5"));
        assertThat(entityList).extracting(OrderEntity::getProductId)
                .containsOnly("101", "102");
        assertThat(entityList).extracting(OrderEntity::getCustomerName)
                .containsOnly("Customer 1", "Customer 2");
        assertThat(entityList).extracting(OrderEntity::getCategory)
                .containsOnly("cat1", "cat2");
        assertThat(entityList).extracting(OrderEntity::getCustomerId)
                .containsOnly("1001", "1002");
        assertThat(entityList).extracting(OrderEntity::getProductName)
                .containsOnly("Product1", "Product2");

    }

    private List<Order> populateOrders() {
        Order order1 = Order.builder()
                .orderId("1")
                .orderDate(LocalDate.of(2012, 12, 12))
                .shipDate(LocalDate.of(2012, 12, 13))
                .shipMode("Postal")
                .quantity(2)
                .discount(new BigDecimal("10.5"))
                .profit(new BigDecimal("12"))
                .productId("101")
                .customerName("Customer 1")
                .category("cat1")
                .customerId("1001")
                .productName("Product1")
                .build();
        Order order2 = Order.builder()
                .orderId("2")
                .orderDate(LocalDate.of(2012, 12, 12))
                .shipDate(LocalDate.of(2012, 12, 13))
                .shipMode("Postal")
                .quantity(4)
                .discount(new BigDecimal("1.5"))
                .profit(new BigDecimal("5"))
                .productId("102")
                .customerName("Customer 2")
                .category("cat2")
                .customerId("1002")
                .productName("Product2")
                .build();
        return Arrays.asList(order1, order2);
    }
}