package com.smattme.usersservice.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.Queue;
import java.util.Map;


@Service
public class JmsQueueListener {

    private Queue queue;
    private Logger logger = LoggerFactory.getLogger(JmsQueueListener.class);

    public JmsQueueListener(Queue queue) {
        this.queue = queue;
    }

    @JmsListener(destination = "SMATT-MICROSERVICE-USER")
    public void processUserProfileQueueResponse(Map<String, Object> payload) {
        logger.info("payload received for user-profile: \n" + payload);
    }
}
