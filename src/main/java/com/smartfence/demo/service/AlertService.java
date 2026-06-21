package com.smartfence.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.smartfence.demo.model.Alert;
import com.smartfence.demo.repository.AlertRepository;

@Service
public class AlertService {

    private final AlertRepository repository;

    public AlertService(AlertRepository repository) {
        this.repository = repository;
    }

    public Alert save(Alert alert) {
        return repository.save(alert);
    }

    public List<Alert> getAllAlerts() {
        return repository.findAll();
    }

    
    
}