package com.smattme.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * Created by seunmatt on 08/11/2018.
 *
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class GatewayServiceApplication {

    public static void main(String... args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }
}
