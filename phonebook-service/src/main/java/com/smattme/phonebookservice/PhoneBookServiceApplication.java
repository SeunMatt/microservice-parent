package com.smattme.phonebookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Created by seunmatt on 08/11/2018.
 *
 */

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class PhoneBookServiceApplication {

    public static void main(String... args) {
        SpringApplication.run(PhoneBookServiceApplication.class, args);
    }

}
