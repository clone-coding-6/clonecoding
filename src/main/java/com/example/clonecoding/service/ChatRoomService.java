package com.example.clonecoding.service;

import com.example.clonecoding.model.ChatRoom;
import com.example.clonecoding.repository.ChatRoomJpaRepository;
import com.example.clonecoding.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ChatRoomService {

    private final ChatRoomJpaRepository chatRoomJpaRepository;
    private final ChatRoomRepository chatRoomRepository;

    @Transactional
    public ChatRoom createRoom(String name) {
        ChatRoom chatRoom = create(name);
        chatRoomJpaRepository.save(chatRoom);
        chatRoomRepository.createChatRoom(chatRoom);
        return chatRoom;
    }

    @Transactional
    public void delete(String roomId) {
        ChatRoom chatRoom = chatRoomJpaRepository.findChatRoomByChatRoomId(roomId);
        chatRoomRepository.deleteChatRoom(chatRoom.getRoomId());
        chatRoomJpaRepository.delete(chatRoom);
    }


    public static ChatRoom create(String name) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.setRoomId(UUID.randomUUID().toString());
        chatRoom.setName(name);
        return chatRoom;
    }

}
