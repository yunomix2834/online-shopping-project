package com.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
//@ComponentScans({ @ComponentScan("com.idenity.controller") })
//@EnableJpaRepositories("com.idenity.repository")
//@EntityScan("com.idenity.entity")
public class CoreApplication {

    static void main(String[] args) {
        SpringApplication.run(CoreApplication.class, args);
    }

}
