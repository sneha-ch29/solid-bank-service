package com.example.solid_principle_example.notification;

import org.springframework.stereotype.Component;

@Component
public class EmailProvider implements MessageProvider {
    @Override
    public void sendMessage(String to, String body) {
        System.out.println("Sending Email to "+ to + ": " + body);
    }
}
