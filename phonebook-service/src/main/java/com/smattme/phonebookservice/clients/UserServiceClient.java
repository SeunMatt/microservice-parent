package com.smattme.phonebookservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Map;

/**
 * Created by seunmatt on 08/11/2018.
 * This is a feign client that'll call the user-service
 * with the endpoint supplied.
 * note that the /users-service/ part is the configured
 * mouth part for the users service in the Gateway Service
 */
@Component
@FeignClient("users-service")
public interface UserServiceClient {

    /**
     * This is the client to get the user details
     * The URL for the GetMapping '/users/{username}' is
     * the path from the users service itself
     * @param username
     * @return Map
     */
    @GetMapping("/users/{username}")
    Map<String, Object> getUserDetailsByUsername(@PathVariable("username") String username);
}
