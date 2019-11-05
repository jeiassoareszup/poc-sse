package com.example.sse.demo.controller;

import com.example.sse.demo.MessageService;
import com.example.sse.demo.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class ConnectController {

    MessageService messageService;

    @Autowired
    public ConnectController(MessageService messageService) {
        this.messageService = messageService;
    }

    @GetMapping(value = "/connect/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<ServerSentEvent<Message>> streamEvents(@PathVariable Integer id) {

        return Flux.interval(Duration.ofSeconds(1))
                .onBackpressureDrop()
                .map(t -> this.messageService.findMessages(id))
                .flatMapIterable(x -> x);
    }

}
