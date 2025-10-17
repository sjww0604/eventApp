package com.eventapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class EventAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventAppApplication.class, args);
    }

}
