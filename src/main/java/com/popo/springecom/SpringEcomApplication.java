package com.popo.springecom;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class SpringEcomApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringEcomApplication.class, args);
    }

}
