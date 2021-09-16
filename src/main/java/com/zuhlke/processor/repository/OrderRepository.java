package com.zuhlke.processor.repository;

import com.zuhlke.processor.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderEntity, Long> {
}
