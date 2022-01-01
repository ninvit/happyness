package com.happyness;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HappynessApplication {

    public static void main(String[] args) {
        SpringApplication.run(HappynessApplication.class, args);
        System.out.println("Hello webflux");
    }

}
