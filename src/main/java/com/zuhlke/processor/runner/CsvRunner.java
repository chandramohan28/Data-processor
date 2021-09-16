package com.zuhlke.processor.runner;

import com.zuhlke.processor.service.CsvService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
public class CsvRunner implements CommandLineRunner {

    private final CsvService csvService;

    @Override
    public void run(String... args) {
        Assert.notEmpty(args,"File path shouldn't be empty");
        Assert.isTrue(args[0].contains(".csv"), "Invalid File Type" );
        String filePath = args[0];
        csvService.extractTransformLoad(filePath);
    }
}
