package com.example.clonecoding.service;

import com.example.clonecoding.dto.ChatMessagedResponseDto;
import com.example.clonecoding.model.ChatMessage;
import com.example.clonecoding.repository.ChatMessageRepository;
import com.example.clonecoding.repository.ChatRoomJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ChatSerivce {

    private final ChatMessageRepository chatMessageRepository;
    private  final ChatRoomJpaRepository chatRoomJPARepository;

    public List<ChatMessagedResponseDto> subMessage(String roomid) {
        //ChatMessage 리스트 중에서 roomid가 내가입장한 roomid와 같은 메세지,
        // 즉, 내가 입장한 방의 메세지를 chatMessageList에 담는다.
        List<ChatMessage> chatMessageList = chatMessageRepository.findByroomId(roomid);

        List<ChatMessagedResponseDto> chatMessagedResponseDtoList = new ArrayList<>();

        for(ChatMessage chatMessage : chatMessageList) {
            ChatMessagedResponseDto chatMessagedResponseDto = new ChatMessagedResponseDto(chatMessage);

            chatMessagedResponseDtoList.add(chatMessagedResponseDto);
        }
        Collections.reverse(chatMessagedResponseDtoList);
        return chatMessagedResponseDtoList;
    }
}
