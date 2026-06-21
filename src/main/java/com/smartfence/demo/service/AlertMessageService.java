package com.smartfence.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartfence.demo.model.AlertMessage;
import com.smartfence.demo.repository.AlertMessageRepository;

@Service
public class AlertMessageService {

    private final AlertMessageRepository repo;

    public AlertMessageService(AlertMessageRepository repo) {
        this.repo = repo;
    }

    public List<AlertMessage> getAllMessages() {
        return repo.findAll();
    }

    public AlertMessage save(AlertMessage msg) {
        return repo.save(msg);
    }
}