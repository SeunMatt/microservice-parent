package com.smattme.usersservice.controllers;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by seunmatt on 08/11/2018
 */
@Controller
public class HomeController {

    private Environment env;

    public HomeController(Environment env) {
        this.env = env;
    }

    @GetMapping("/")
    public ResponseEntity index() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", "Welcome to Users Service of Seun Matt. This instance is running on port " + env.getProperty("server.port"));
        return  ResponseEntity.ok(response);
    }
}
