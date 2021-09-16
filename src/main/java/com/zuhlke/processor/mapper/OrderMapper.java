package com.zuhlke.processor.mapper;

import com.zuhlke.processor.entity.OrderEntity;
import com.zuhlke.processor.model.Order;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderMapper {

    public List<OrderEntity> mapList(List<Order> orders) {
        List<OrderEntity> orderEntities = new ArrayList<>();
        orders.forEach(order -> {
            OrderEntity entity = new OrderEntity();
            entity.setOrderId(order.getOrderId());
            entity.setOrderDate(order.getOrderDate());
            entity.setShipDate(order.getShipDate());
            entity.setShipMode(order.getShipMode());
            entity.setQuantity(order.getQuantity());
            entity.setDiscount(order.getDiscount());
            entity.setProfit(order.getProfit());
            entity.setProductId(order.getProductId());
            entity.setCustomerName(order.getCustomerName());
            entity.setCategory(order.getCategory());
            entity.setCustomerId(order.getCustomerId());
            entity.setProductName(order.getProductName());
            orderEntities.add(entity);
        });

        return orderEntities;
    }
}
