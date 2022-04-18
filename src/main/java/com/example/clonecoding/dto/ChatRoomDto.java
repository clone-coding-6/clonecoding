package com.example.clonecoding.dto;

import com.example.clonecoding.model.MessageType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

public class ChatRoomDto {

    @AllArgsConstructor
    @Builder
    @Data
    public static class RoomJoinRequestDto{
        MessageType type;

        String roomId;

        String sender;

        String message;
    }

    @AllArgsConstructor
    @Builder
    @Data
    public static class RoomDeleteRequestDto{
        String roomId;
    }
}
