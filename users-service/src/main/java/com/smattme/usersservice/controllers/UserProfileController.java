package com.smattme.usersservice.controllers;

import com.smattme.usersservice.service.UserProfileService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by seunmatt on 08/11/2018.
 */
@Controller
@RequestMapping("users")
public class UserProfileController {

    private UserProfileService userProfileService;

    public UserProfileController(UserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }


    @GetMapping("/{username}")
    public ResponseEntity details(@PathVariable("username") String username) {

        Map<String, Object> response = userProfileService.getUserDetailByUsername(username);
        if(!Boolean.parseBoolean(response.get("status").toString()))
            return ResponseEntity.badRequest().body(response);

        return ResponseEntity.ok(response);
    }

}
