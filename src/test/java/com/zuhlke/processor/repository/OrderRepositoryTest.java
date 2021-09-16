package com.zuhlke.processor.repository;

import com.zuhlke.processor.entity.OrderEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository orderRepository;

    @Test
    @DisplayName("Verify if order id  is not null")
    public void shouldNot_Allow_To_Persistence_When_OrderId_IsNull() {
        OrderEntity entity = populateOrderEntity();
        entity.setOrderId(null);
        assertThatThrownBy(() -> {
            orderRepository.save(entity);
        }).isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("not-null property references a null or transient value : com.zuhlke.processor.entity.OrderEntity.orderId");
    }

    @Test
    @DisplayName("Verify if Order Date  is not null")
    public void shouldNot_Allow_To_Persistence_When_OrderDate_IsNull() {
        OrderEntity entity = populateOrderEntity();
        entity.setOrderDate(null);
        assertThatThrownBy(() -> {
            orderRepository.save(entity);
        }).isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("not-null property references a null or transient value : com.zuhlke.processor.entity.OrderEntity.orderDate");
    }

    @Test
    @DisplayName("Verify if ship date  is not null")
    public void shouldNot_Allow_To_Persistence_When_ShipDate_IsNull() {
        OrderEntity entity = populateOrderEntity();
        entity.setShipDate(null);
        assertThatThrownBy(() -> {
            orderRepository.save(entity);
        }).isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("not-null property references a null or transient value : com.zuhlke.processor.entity.OrderEntity.shipDate");
    }

    @Test
    @DisplayName("Verify if quantity is not null")
    public void shouldNot_Allow_To_Persistence_When_Quantity_IsNull() {
        OrderEntity entity = populateOrderEntity();
        entity.setQuantity(null);
        assertThatThrownBy(() -> {
            orderRepository.save(entity);
        }).isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("not-null property references a null or transient value : com.zuhlke.processor.entity.OrderEntity.quantity");
    }

    @Test
    @DisplayName("Verify if profit  is not null")
    public void shouldNot_Allow_To_Persistence_When_Profit_IsNull() {
        OrderEntity entity = populateOrderEntity();
        entity.setProfit(null);
        assertThatThrownBy(() -> {
            orderRepository.save(entity);
        }).isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("not-null property references a null or transient value : com.zuhlke.processor.entity.OrderEntity.profit");
    }

    @Test
    @DisplayName("Verify if Product Id  is not null")
    public void shouldNot_Allow_To_Persistence_When_ProductId_IsNull() {
        OrderEntity entity = populateOrderEntity();
        entity.setProductId(null);
        assertThatThrownBy(() -> {
            orderRepository.save(entity);
        }).isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("not-null property references a null or transient value : com.zuhlke.processor.entity.OrderEntity.productId");
    }

    @Test
    @DisplayName("Verify if customer name  is not null")
    public void shouldNot_Allow_To_Persistence_When_CustomerName_IsNull() {
        OrderEntity entity = populateOrderEntity();
        entity.setCustomerName(null);
        assertThatThrownBy(() -> {
            orderRepository.save(entity);
        }).isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("not-null property references a null or transient value : com.zuhlke.processor.entity.OrderEntity.customerName");
    }


    @Test
    @DisplayName("Verify if Category  is not null")
    public void shouldNot_Allow_To_Persistence_When_Category_IsNull() {
        OrderEntity entity = populateOrderEntity();
        entity.setCategory(null);
        assertThatThrownBy(() -> {
            orderRepository.save(entity);
        }).isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("not-null property references a null or transient value : com.zuhlke.processor.entity.OrderEntity.category");
    }

    @Test
    @DisplayName("Verify if customer id  is not null")
    public void shouldNot_Allow_To_Persistence_When_CustomerId_IsNull() {
        OrderEntity entity = populateOrderEntity();
        entity.setCustomerId(null);
        assertThatThrownBy(() -> {
            orderRepository.save(entity);
        }).isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("not-null property references a null or transient value : com.zuhlke.processor.entity.OrderEntity.customerId");
    }

    @Test
    @DisplayName("Verify Order Id uniqueness")
    public void shouldNot_Allow_Duplicate_OrderId() {
        OrderEntity entity = populateOrderEntity();
        orderRepository.save(entity);
        OrderEntity entity1 = populateOrderEntity();
        entity1.setCustomerId("Cust2");
        entity1.setProductId("Prod2");
        assertThatThrownBy(() -> {
            orderRepository.save(entity1);
        }).isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("could not execute statement; SQL [n/a]; constraint");
    }

    @Test
    @DisplayName("Verify Customer Id uniqueness")
    public void shouldNot_Allow_Duplicate_CustomerId() {
        OrderEntity entity = populateOrderEntity();
        orderRepository.save(entity);
        OrderEntity entity1 = populateOrderEntity();
        entity1.setOrderId("2");
        entity1.setProductId("Prod2");
        assertThatThrownBy(() -> {
            orderRepository.save(entity1);
        }).isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("could not execute statement; SQL [n/a]; constraint");
    }

    @Test
    @DisplayName("Verify Product Id uniqueness")
    public void shouldNot_Allow_Duplicate_ProductId() {
        OrderEntity entity = populateOrderEntity();
        orderRepository.save(entity);
        OrderEntity entity1 = populateOrderEntity();
        entity1.setCustomerId("Cust2");
        entity1.setOrderId("2");
        assertThatThrownBy(() -> {
            orderRepository.save(entity1);
        }).isInstanceOf(DataIntegrityViolationException.class)
                .hasMessageContaining("could not execute statement; SQL [n/a]; constraint");
    }

    @Test
    @DisplayName("Verify if entity passed is saved")
    public void should_return_Passed_Entity_To_Save() {
        OrderEntity response = orderRepository.save(populateOrderEntity());
        assertThat(response).isNotNull();
        assertThat(response).extracting(OrderEntity::getOrderId)
                .isEqualTo("1");
        assertThat(response).extracting(OrderEntity::getOrderDate)
                .isEqualTo(LocalDate.of(2012, 12, 12));
        assertThat(response).extracting(OrderEntity::getShipDate)
                .isEqualTo(LocalDate.of(2012, 12, 13));
        assertThat(response).extracting(OrderEntity::getShipMode)
                .isEqualTo("Postal");
        assertThat(response).extracting(OrderEntity::getQuantity)
                .isEqualTo(4);
        assertThat(response).extracting(OrderEntity::getDiscount)
                .isEqualTo(new BigDecimal("34"));
        assertThat(response).extracting(OrderEntity::getProfit)
                .isEqualTo(new BigDecimal("23"));
        assertThat(response).extracting(OrderEntity::getProductId)
                .isEqualTo("101");
        assertThat(response).extracting(OrderEntity::getCustomerName)
                .isEqualTo("Cust1");
        assertThat(response).extracting(OrderEntity::getCategory)
                .isEqualTo("Cat1");
        assertThat(response).extracting(OrderEntity::getCustomerId)
                .isEqualTo("1001");
        assertThat(response).extracting(OrderEntity::getProductName)
                .isEqualTo("Prod1");
    }

    private OrderEntity populateOrderEntity() {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setOrderId("1");
        orderEntity.setOrderDate(LocalDate.of(2012, 12, 12));
        orderEntity.setShipDate(LocalDate.of(2012, 12, 13));
        orderEntity.setShipMode("Postal");
        orderEntity.setQuantity(4);
        orderEntity.setDiscount(new BigDecimal("34"));
        orderEntity.setProfit(new BigDecimal("23"));
        orderEntity.setProductId("101");
        orderEntity.setCustomerName("Cust1");
        orderEntity.setCategory("Cat1");
        orderEntity.setCustomerId("1001");
        orderEntity.setProductName("Prod1");
        return orderEntity;
    }
}