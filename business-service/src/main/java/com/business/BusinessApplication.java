package com.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@ComponentScans({ @ComponentScan("com.demo.controller") })
//@EnableJpaRepositories("com.demo.repository")
//@EntityScan("com.demo.entity")
@EnableConfigurationProperties(value = {DemoConfigurationExampleDto.class})
public class BusinessApplication {

    static void main(String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }

}
