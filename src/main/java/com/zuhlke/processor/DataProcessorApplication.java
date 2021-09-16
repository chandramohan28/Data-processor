package com.zuhlke.processor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class DataProcessorApplication {

    public static void main(String[] args) {
        System.out.println("Application Starting");
        SpringApplication.run(DataProcessorApplication.class, args);
        System.out.println("Application Ended");
    }

}
