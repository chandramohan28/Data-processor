package com.zuhlke.processor.helper;

import com.zuhlke.processor.exception.TechnicalException;
import com.zuhlke.processor.model.Order;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static com.zuhlke.processor.constant.CsvConstants.*;
import static com.zuhlke.processor.util.CsvUtil.*;

public class CsvHelper {

    public static List<Order> extractCsvToOrder(String filePath) {
        try (BufferedReader fileReader = new BufferedReader(new InputStreamReader(readFile(filePath), StandardCharsets.UTF_8));
             CSVParser csvParser = new CSVParser(fileReader,
                     CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim())) {
            List<Order> orders = new ArrayList<>();
            Iterable<CSVRecord> csvRecords = csvParser.getRecords();
            csvRecords.forEach(record -> {
                Order order = Order.builder()
                        .orderId(record.get(ORDER_ID))
                        .orderDate(formatDate(record.get(ORDER_DATE)))
                        .shipDate(formatDate(record.get(SHIP_DATE)))
                        .shipMode(record.get(SHIP_MODE))
                        .quantity(Integer.parseInt(record.get(QUANTITY)))
                        .discount(getBigDecimal(record.get(DISCOUNT)))
                        .profit(getBigDecimal(record.get(PROFIT)))
                        .productId(record.get(PRODUCT_ID))
                        .customerName(record.get(CUSTOMER_NAME))
                        .category(record.get(CATEGORY))
                        .customerId(record.get(CUSTOMER_ID))
                        .productName(record.get(PRODUCT_NAME))
                        .build();
                orders.add(order);
            });
            return orders;
        } catch (IOException e) {
            throw new TechnicalException("File not found in the path : " + filePath + e.getMessage());
        }
    }
}
