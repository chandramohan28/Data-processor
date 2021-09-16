package com.zuhlke.processor.service;

import com.zuhlke.processor.entity.OrderEntity;
import com.zuhlke.processor.mapper.OrderMapper;
import com.zuhlke.processor.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.mock;

@RunWith(MockitoJUnitRunner.class)
class CsvServiceTest {

    OrderMapper mapper = mock(OrderMapper.class);
    OrderRepository orderRepository = mock(OrderRepository.class);
    CsvService csvService = mock(CsvService.class);

    @Test
    @DisplayName("Verify Csv Service")
    public void verify_Csv_Service() {
        given(mapper.mapList(anyList())).willReturn(populateOrderEntity());
        given(orderRepository.saveAll(anyList())).willReturn(populateOrderEntity());
        csvService.extractTransformLoad("classpath:test.csv");
        verify(csvService, times(1)).extractTransformLoad(anyString());
    }

    private List<OrderEntity> populateOrderEntity() {
        OrderEntity orderEntity1 = new OrderEntity();
        orderEntity1.setOrderId("1");
        orderEntity1.setOrderDate(LocalDate.of(2012, 12, 12));
        orderEntity1.setShipDate(LocalDate.of(2012, 12, 13));
        orderEntity1.setShipMode("Postal");
        orderEntity1.setQuantity(4);
        orderEntity1.setDiscount(new BigDecimal("34"));
        orderEntity1.setProfit(new BigDecimal("23"));
        orderEntity1.setProductId("101");
        orderEntity1.setCustomerName("Cust1");
        orderEntity1.setCategory("Cat1");
        orderEntity1.setCustomerId("1001");
        orderEntity1.setProductName("Prod1");

        OrderEntity orderEntity2 = new OrderEntity();
        orderEntity2.setOrderId("2");
        orderEntity2.setOrderDate(LocalDate.of(2012, 12, 12));
        orderEntity2.setShipDate(LocalDate.of(2012, 12, 13));
        orderEntity2.setShipMode("Postal");
        orderEntity2.setQuantity(4);
        orderEntity2.setDiscount(new BigDecimal("34"));
        orderEntity2.setProfit(new BigDecimal("23"));
        orderEntity2.setProductId("102");
        orderEntity2.setCustomerName("Cust2");
        orderEntity2.setCategory("Cat2");
        orderEntity2.setCustomerId("1002");
        orderEntity2.setProductName("Prod2");

        return Arrays.asList(orderEntity1, orderEntity2);
    }
}