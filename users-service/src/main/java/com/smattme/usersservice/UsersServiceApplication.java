package com.smattme.usersservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * Created by seunmatt on 08/11/2018.
 *
 */
@SpringBootApplication
//@EnableEurekaClient
public class UsersServiceApplication {

    public static void main(String ... args) {
        SpringApplication.run(UsersServiceApplication.class, args);
    }
}
