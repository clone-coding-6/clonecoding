package com.example.clonecoding.dto;

import com.example.clonecoding.model.Timestamped;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessageDto extends Timestamped {
    // 메시지 타입 : 입장, 채팅
    public enum MessageType {
        ENTER, JOIN, TALK
    }
    private MessageType type; // 메시지 타입
    private String roomId; // 방번호
    private String sender; // 메시지 보낸사람
    private String message; // 메시지
}