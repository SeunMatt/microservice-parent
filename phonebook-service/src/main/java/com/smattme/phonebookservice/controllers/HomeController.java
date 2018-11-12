package com.smattme.phonebookservice.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by seunmatt on 08/11/2018.
 *
 */
@Controller
public class HomeController {

    @GetMapping("/")
    public ResponseEntity index() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", true);
        response.put("message", "Welcome to the Phone Book Service");
        return ResponseEntity.ok(response);
    }
}
