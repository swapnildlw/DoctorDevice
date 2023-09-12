package com.stackroute.UserService.service;

import com.stackroute.UserService.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserMessageSender {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendUserCredentials(User user) {
        rabbitTemplate.convertAndSend("credentialsExchange", "credentialsRoutingKey", user);
    }
}
