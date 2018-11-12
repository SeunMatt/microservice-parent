package com.smattme.phonebookservice.controllers;

import com.smattme.phonebookservice.clients.UserServiceClient;
import com.smattme.phonebookservice.service.PhoneBookGroupService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * Created by seunmatt on 08/11/2018.
 *
 */
@Controller
@RequestMapping("/phonebook/groups")
public class PhoneBookGroupController {

    private PhoneBookGroupService phoneBookGroupService;
    private UserServiceClient userServiceClient;
    private Logger logger = LoggerFactory.getLogger(getClass().getName());

    @Autowired
    public PhoneBookGroupController(PhoneBookGroupService phoneBookGroupService,
                                    UserServiceClient userServiceClient) {
        this.phoneBookGroupService = phoneBookGroupService;
        this.userServiceClient = userServiceClient;
    }

    @GetMapping("/{username}")
    public ResponseEntity index(@PathVariable String username) {

        //get the userdetails with the username from the user-service
        Map<String, Object> userServiceResponse = userServiceClient.getUserDetailsByUsername(username);
        logger.debug("raw user-service response in phone book service: \n" + userServiceResponse);
        if(!Boolean.parseBoolean(userServiceResponse.get("status").toString())) {
            return ResponseEntity.badRequest().body(userServiceResponse);
        }


        Map<String, String> userProfile = (Map<String, String>) userServiceResponse.get("user");
        logger.debug("user profile: \n" + userProfile);

        String userId = userProfile.get("id").toString();
        Map<String, Object> response = phoneBookGroupService.getAllPhoneBookGroups(userId);
        logger.debug("raw response for groups: \n" + response);
        if(!Boolean.parseBoolean(response.get("status").toString()))
            return ResponseEntity.badRequest().body(response);

        return ResponseEntity.ok(response);
    }
}
