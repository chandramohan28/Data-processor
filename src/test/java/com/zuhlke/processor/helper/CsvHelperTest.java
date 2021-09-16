package com.zuhlke.processor.helper;

import com.zuhlke.processor.exception.TechnicalException;
import com.zuhlke.processor.model.Order;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CsvHelperTest {

    @Test
    @DisplayName("Verify if returns InputStream")
    public void should_Return_InputStream() {
        List<Order> orderList = CsvHelper.extractCsvToOrder("classpath:test.csv");
        assertThat(orderList).isNotNull();
        assertThat(orderList).extracting(Order::getOrderId)
                .containsOnly("CA-2016-152156", "CA-2016-152156");
        assertThat(orderList).extracting(Order::getOrderDate)
                .containsOnly(LocalDate.of(2016, 11, 8), LocalDate.of(2016, 11, 8));
        assertThat(orderList).extracting(Order::getShipDate)
                .containsOnly(LocalDate.of(2016, 11, 11), LocalDate.of(2016, 11, 11));
        assertThat(orderList).extracting(Order::getShipMode)
                .containsOnly("Second Class", "Second Class");
        assertThat(orderList).extracting(Order::getQuantity)
                .containsOnly(2, 3);
        assertThat(orderList).extracting(Order::getDiscount)
                .containsOnly(new BigDecimal("0"), new BigDecimal("0"));
        assertThat(orderList).extracting(Order::getProfit)
                .containsOnly(new BigDecimal("41.9136"), new BigDecimal("219.582"));
        assertThat(orderList).extracting(Order::getProductId)
                .containsOnly("FUR-BO-10001798", "FUR-CH-10000454");
        assertThat(orderList).extracting(Order::getCustomerName)
                .containsOnly("Claire Gute", "Claire Gute");
        assertThat(orderList).extracting(Order::getCategory)
                .containsOnly("Furniture", "Furniture");
        assertThat(orderList).extracting(Order::getCustomerId)
                .containsOnly("CG-12520", "CG-12520");
        assertThat(orderList).extracting(Order::getProductName)
                .containsOnly("Bush Somerset Collection Bookcase", "Hon Deluxe Fabric Upholstered Stacking Chairs, Rounded Back");
    }

    @Test
    @DisplayName("Verify exception message for invalid file path")
    public void should_Throw_Exception_When_Invalid_File_Path() {
        assertThatThrownBy(() -> {
            CsvHelper.extractCsvToOrder("sales.csv");
        }).isInstanceOf(TechnicalException.class)
                .hasMessageContaining("File not found in the path : sales.csv");
    }

    @Test
    @DisplayName("Verify exception message for null file path")
    public void should_Throw_Exception_When_Null_File_Path() {
        assertThatThrownBy(() -> {
            CsvHelper.extractCsvToOrder(null);
        }).isInstanceOf(TechnicalException.class)
                .hasMessageContaining("Invalid File Path : ");
    }

}