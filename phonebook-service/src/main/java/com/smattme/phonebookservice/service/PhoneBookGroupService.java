package com.smattme.phonebookservice.service;

import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by seunmatt on 08/11/2018.
 *
 */
@Service
public class PhoneBookGroupService {

    private Map<String, List<String>> phoneBookGroups = new HashMap<>();

    {
        phoneBookGroups.put("1", Arrays.asList("international_numbers", "monthly_meeting", "padi-padi"));
    }

    public PhoneBookGroupService() {}

    /**
     * this function will be used to fetch all the
     * phone book groups for the user with the supplied username
     * @param userId
     * @return
     */
    public Map<String, Object> getAllPhoneBookGroups(String userId) {

        Map<String, Object> response = new HashMap<>();

        if(!phoneBookGroups.containsKey(userId)) {
            response.put("status", true);
            response.put("phone_book_groups", Collections.emptyList());
            response.put("message", "No phone book groups found. Please create a new one and try again");
            return  response;
        }

        response.put("status", true);
        response.put("phone_book_groups", phoneBookGroups.get(userId));
        response.put("message", "Operation Successful");
        return response;

    }
}
