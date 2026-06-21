package com.smartfence.demo.controller;

import java.time.OffsetDateTime;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartfence.demo.model.AlertMessage;
import com.smartfence.demo.service.AlertMessageService;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/alert_messages")
public class AlertWebSocketController {

    private final AlertMessageService service;

    public AlertWebSocketController(AlertMessageService service) {
        this.service = service;
    }

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public AlertMessage send(@Payload AlertMessage msg) {

        System.out.println(
            "Incoming: " +
            msg.getName() +
            " - " +
            msg.getMessage() +
            " | Lat: " +
            msg.getLatitude() +
            " | Lng: " +
            msg.getLongitude()
        );

        // 🕒 Set current timestamp
        msg.setTimestamp(OffsetDateTime.now());

        // ✅ Save to database
        AlertMessage savedMessage = service.save(msg);

        // ✅ Return saved object to websocket subscribers
        return savedMessage;
    }
}