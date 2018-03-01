package com.lxt.center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * eureka注册中心
 *
 * @author zer0
 * @version 1.0
 */

@EnableEurekaServer
@SpringBootApplication
public class JeroCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(JeroCenterApplication.class, args);
    }

}
