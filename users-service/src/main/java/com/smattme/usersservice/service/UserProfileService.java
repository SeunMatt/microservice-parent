package com.smattme.usersservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by seunmatt on 08/11/2018
 *
 */
@Service
public class UserProfileService {

    private Map<String, Map<String, String>> users = new HashMap<>();
    private JmsTemplate jmsTemplate;
    private Queue queue;


    {
        Map<String, String> user = new HashMap<>();
        user.put("first_name", "Seun");
        user.put("last_name", "Matt");
        user.put("email", "om@clane.com");
        user.put("id", "1");
        users.put("smatt", user);

        user = new HashMap<>();
        user.put("first_name", "Queen");
        user.put("last_name", "May");
        user.put("email", "qm@clane.com");
        user.put("id", "2");
        users.put("qm", user);
    }

    @Autowired
    public UserProfileService(JmsTemplate jmsTemplate, Queue queue) {
        this.jmsTemplate = jmsTemplate;
        this.queue = queue;
    }

    public Map<String, Object> getUserDetailByUsername(String username) {

        Map<String, Object> response = new HashMap<>();

        if(!users.containsKey(username)) {
            response.put("status", false);
            response.put("error", "User [" + username + "] not found!");
            return  response;
        }

        response.put("status", true);
        response.put("user", users.get(username));

        jmsTemplate.convertAndSend(queue, response);

        return response;
    }


}
