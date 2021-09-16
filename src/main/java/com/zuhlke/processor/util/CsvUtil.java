package com.zuhlke.processor.util;

import com.zuhlke.processor.exception.TechnicalException;
import org.springframework.util.ResourceUtils;
import java.io.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public final class CsvUtil {
    public static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yy");

    public static LocalDate formatDate(String date) {
        LocalDate formattedDate;
        try {
            formattedDate = LocalDate.parse(date, FORMATTER);
        } catch (Exception e) {
            throw new TechnicalException("Invalid date format: " + date + e.getMessage());
        }
        return formattedDate;
    }

    public static InputStream readFile(String filePath) {
        File file;
        FileInputStream fileInputStream;
        try {
            file = ResourceUtils.getFile(filePath);
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new TechnicalException("File not found in the path : " + filePath + e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new TechnicalException("Invalid File Path : " + filePath + e.getMessage());
        }

        return fileInputStream;
    }


    public static BigDecimal getBigDecimal(String amount) {
        BigDecimal bigDecimalAmount;
        try {
            bigDecimalAmount = new BigDecimal(amount);
        } catch (Exception e) {
            throw new TechnicalException("Invalid amount format: " + amount + e.getMessage());
        }
        return bigDecimalAmount;
    }
}
