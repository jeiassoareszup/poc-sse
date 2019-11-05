package com.example.sse.demo;

import com.example.sse.demo.entity.Message;
import com.example.sse.demo.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public List<ServerSentEvent<Message>> findMessages(Integer id) {
        List<Message> messages = this.messageRepository.findByReceiverIdAndSentAtIsNull(id);

        messages.forEach(m -> {
            m.setSentAt(LocalDateTime.now());
            messageRepository.save(m);
        });

        return messages.stream().map(this::generateEvent).collect(Collectors.toList());
    }

    private ServerSentEvent<Message> generateEvent(Message message) {

        return ServerSentEvent.<Message>builder()
                .id(String.valueOf(message.getId()))
                .event("nofitication")
                .data(message)
                .build();
    }
}
