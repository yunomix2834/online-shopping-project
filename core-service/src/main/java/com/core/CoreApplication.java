package com.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
    scanBasePackages = {
        "com.core",
        "org.common"
    }
)
public class CoreApplication {

    static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }
}
