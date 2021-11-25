package com.sefa.examples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ExamplesWithSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExamplesWithSpringBootApplication.class, args);
    }

}
