package com.example.sse.demo.controller;

import com.example.sse.demo.entity.Message;
import com.example.sse.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    MessageRepository messageRepository;

    @Autowired
    public MessageController(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @PostMapping("/messages")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Message message){
        this.messageRepository.save(message);
    }
}

