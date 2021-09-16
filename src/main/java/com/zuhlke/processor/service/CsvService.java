package com.zuhlke.processor.service;


import com.zuhlke.processor.entity.OrderEntity;
import com.zuhlke.processor.mapper.OrderMapper;
import com.zuhlke.processor.model.Order;
import com.zuhlke.processor.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.zuhlke.processor.helper.CsvHelper.extractCsvToOrder;

@Slf4j
@Service
@RequiredArgsConstructor
public class CsvService {

    private final OrderMapper orderMapper;
    private final OrderRepository repository;

    public void extractTransformLoad(String filePath) {
        List<Order> orders = extractCsvToOrder(filePath);
        List<OrderEntity> orderEntityList = orderMapper.mapList(orders);
        orderEntityList= (List<OrderEntity>) repository.saveAll(orderEntityList);
        log.info("Total Number of rows inserted : {}", orderEntityList.size());
    }
}
