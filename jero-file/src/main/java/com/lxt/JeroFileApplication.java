package com.lxt;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.lxt")
public class JeroFileApplication {

    private static final Logger logger = LoggerFactory.getLogger(JeroFileApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JeroFileApplication.class, args);
        logger.info("JeroFileApplication started successfully!");
    }

}
