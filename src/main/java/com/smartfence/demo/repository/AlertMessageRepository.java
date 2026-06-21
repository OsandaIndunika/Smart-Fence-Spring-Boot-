package com.smartfence.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartfence.demo.model.AlertMessage;

public interface AlertMessageRepository extends JpaRepository<AlertMessage, Long> {

    // Get all messages sorted
    List<AlertMessage> findAllByOrderByTimestampDesc();

    // Get paginated messages 
    //Page<AlertMessage> findAllByOrderByTimestampDesc(Pageable pageable);
}