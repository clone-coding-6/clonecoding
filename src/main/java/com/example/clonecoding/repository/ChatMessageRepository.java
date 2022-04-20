package com.example.clonecoding.repository;

import com.example.clonecoding.model.ChatMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface ChatMessageRepository extends JpaRepository<ChatMessage,Long> {
    List<ChatMessage> findByroomId(String roomid);
}
