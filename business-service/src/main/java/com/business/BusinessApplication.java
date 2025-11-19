package com.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
    scanBasePackages = {
        "com.business",
        "org.common"
    }
)
@EnableFeignClients
public class BusinessApplication {

  public static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }
}
