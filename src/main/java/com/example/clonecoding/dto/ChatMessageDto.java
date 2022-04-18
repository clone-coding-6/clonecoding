package com.example.clonecoding.dto;

import com.example.clonecoding.model.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ChatMessageDto {

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Request{
        MessageType type; // 메시지 타입
        String roomId; // 방번호
        String sender; // 메시지 보낸사람
        String message; // 메시지
    }
}
