package com.example.sse.demo.repository;

import com.example.sse.demo.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    List<Message> findByReceiverIdAndSentAtIsNull(Integer receiverId);
}
