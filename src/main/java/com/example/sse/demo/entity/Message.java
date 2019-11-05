package com.example.sse.demo.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "message")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;
    private Integer authorId;
    private Integer receiverId;
    private LocalDateTime sentAt;

    public Message() {
    }

    public Message(Integer id, String content, Integer authorId, Integer receiverId, LocalDateTime sentAt) {
        this.id = id;
        this.content = content;
        this.authorId = authorId;
        this.receiverId = receiverId;
        this.sentAt = sentAt;
    }

    public LocalDateTime getSentAt() {
        return sentAt;
    }

    public void setSentAt(LocalDateTime sentAt) {
        this.sentAt = sentAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public Integer getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(Integer receiverId) {
        this.receiverId = receiverId;
    }
}
