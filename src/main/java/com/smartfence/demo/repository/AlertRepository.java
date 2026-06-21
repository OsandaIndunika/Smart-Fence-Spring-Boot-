package com.smartfence.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartfence.demo.model.Alert;

public interface AlertRepository extends JpaRepository<Alert, Long> {
}