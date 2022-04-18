package com.example.clonecoding.dto;

import com.example.clonecoding.model.ChatMessage;
import com.example.clonecoding.model.ChatRoom;
import com.example.clonecoding.model.MessageType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class ChatMessagedResponseDto {

    private MessageType type;
    private String roomId;
    private String sender;
    private String message;
    private String imageUrl;
    private LocalDateTime createdAt;
    private ChatRoom chatRoom;

    public ChatMessagedResponseDto (ChatMessage chatMessage) {
        this.type = chatMessage.getType();
        this.roomId = chatMessage.getRoomId();
        this.sender = chatMessage.getSender();
        this.message = chatMessage.getMessage();
        this.imageUrl = chatMessage.getImageUrl();
        this.createdAt = chatMessage.getCreatedAt();
        this.chatRoom = chatMessage.getChatRoom();
    }


}