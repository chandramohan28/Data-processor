package com.zuhlke.processor.util;

import com.zuhlke.processor.exception.TechnicalException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CsvUtilTest {

    @Test
    @DisplayName("Verify if returns valid date format")
    public void should_Return_Valid_Date_Format() {
        LocalDate date = CsvUtil.formatDate("12.12.12");
        assertThat(date).isNotNull();
        assertThat(date).isEqualTo(LocalDate.of(2012, 12, 12));
    }

    @Test
    @DisplayName("Verify exception message for invalid date format")
    public void should_Throw_Exception_When_Invalid_Date_Format() {
        assertThatThrownBy(() -> {
            CsvUtil.formatDate("12/12/12");
        }).isInstanceOf(TechnicalException.class)
                .hasMessageContaining("Invalid date format: 12/12/12");
    }

    @Test
    @DisplayName("Verify exception message for null date")
    public void should_Throw_Exception_When_Null_Date() {
        assertThatThrownBy(() -> {
            CsvUtil.formatDate(null);
        }).isInstanceOf(TechnicalException.class)
                .hasMessageContaining("Invalid date format: ");
    }

    @Test
    @DisplayName("Verify if returns InputStream")
    public void should_Return_InputStream() {
        InputStream inputStream = CsvUtil.readFile("classpath:sales.csv");
        assertThat(inputStream).isNotNull();
        assertThat(inputStream).isInstanceOf(InputStream.class);
    }

    @Test
    @DisplayName("Verify exception message for invalid file path")
    public void should_Throw_Exception_When_Invalid_File_Path() {
        assertThatThrownBy(() -> {
            CsvUtil.readFile("sales.csv");
        }).isInstanceOf(TechnicalException.class)
                .hasMessageContaining("File not found in the path : sales.csv");
    }

    @Test
    @DisplayName("Verify exception message for null file path")
    public void should_Throw_Exception_When_Null_File_Path() {
        assertThatThrownBy(() -> {
            CsvUtil.readFile(null);
        }).isInstanceOf(TechnicalException.class)
                .hasMessageContaining("Invalid File Path : ");
    }

    @Test
    @DisplayName("Verify if returns BigDecimal")
    public void should_Return_BigDecimal() {
        BigDecimal bigDecimal = CsvUtil.getBigDecimal("34");
        assertThat(bigDecimal).isNotNull();
        assertThat(bigDecimal).isEqualTo(new BigDecimal("34"));
    }

    @Test
    @DisplayName("Verify exception message for invalid number")
    public void should_Throw_Exception_When_Invalid_Number() {
        assertThatThrownBy(() -> {
            CsvUtil.getBigDecimal("abc");
        }).isInstanceOf(TechnicalException.class)
                .hasMessageContaining("Invalid amount format: abc");
    }

    @Test
    @DisplayName("Verify exception message for null")
    public void should_Throw_Exception_When_Null() {
        assertThatThrownBy(() -> {
            CsvUtil.getBigDecimal(null);
        }).isInstanceOf(TechnicalException.class)
                .hasMessageContaining("Invalid amount format: ");
    }
}