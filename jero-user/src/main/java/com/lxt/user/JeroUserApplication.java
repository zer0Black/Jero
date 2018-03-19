package com.lxt.user;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@ComponentScan("com.lxt")
@MapperScan(basePackages = "com.lxt.user.mapper")
public class JeroUserApplication {

    private static final Logger logger = LoggerFactory.getLogger(JeroUserApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(JeroUserApplication.class, args);
        logger.info("JeroUserApplication started successfully!");
    }

}
