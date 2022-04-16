package com.example.clonecoding.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
public class ChatRoomDto implements Serializable {

    private static final long serialVersionUID = 6494678977089006639L;

    private String roomId;
    private String name;

    public static ChatRoomDto create(String name) {
        ChatRoomDto chatRoomDto = new ChatRoomDto();
        chatRoomDto.roomId = UUID.randomUUID().toString();
        chatRoomDto.name = name;
        return chatRoomDto;
    }
}


