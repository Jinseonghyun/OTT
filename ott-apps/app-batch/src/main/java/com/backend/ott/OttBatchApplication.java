package com.backend.ott;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class OttBatchApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(OttBatchApplication.class, args);
        SpringApplication.exit(run);
    }
}
