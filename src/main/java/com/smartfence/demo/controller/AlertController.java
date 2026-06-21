package com.smartfence.demo.controller;

import java.util.List;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.smartfence.demo.model.Alert;
import com.smartfence.demo.model.AlertMessage;
import com.smartfence.demo.service.AlertMessageService;
import com.smartfence.demo.service.AlertService;

@RestController
@RequestMapping("/api/alerts")
@CrossOrigin(origins = "*")
public class AlertController {

    private final AlertService service;
    private final AlertMessageService messageService; 
    private final SimpMessagingTemplate messagingTemplate;

    public AlertController(AlertService service, AlertMessageService messageService,SimpMessagingTemplate messagingTemplate) { // ✅ updated constructor
        this.service = service;
        this.messageService = messageService;
        this.messagingTemplate = messagingTemplate;
    }


    @PostMapping
    public Alert receive(@RequestBody Alert alert) {

        System.out.println("🚨 Beam Triggered: " + alert.getTimestamp());

        Alert saved = service.save(alert);

        // 🔥 SEND TO WEBSOCKET
        messagingTemplate.convertAndSend("/topic/alerts", saved);

        return saved;
    }

    @GetMapping
    public List<Alert> getAll() {
        return service.getAllAlerts();
    }

    @GetMapping("/messages")
    public List<AlertMessage> getAllMessages() {
        return messageService.getAllMessages();
    }

    
}

