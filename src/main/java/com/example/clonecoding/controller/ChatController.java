package com.example.clonecoding.controller;

import com.example.clonecoding.dto.ChatMessageDto;
import com.example.clonecoding.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

@RequiredArgsConstructor
@Controller
public class ChatController {

    private final ChatMessageService chatMessageService;

    //websocket "/pub/chat/message"로 들어오는 메시징을 처리한다.
    //websocket "w"로 들어오는 메시징을 처리한다.
    @MessageMapping("/chat/message")
    public void message(ChatMessageDto.Request message) {
        chatMessageService.joinMessage(message);
    }
}

//{
//        "type":"ENTER",
//        "roomId":"622fe8eb-69fc-41ab-bd14-a2849d2ae482",
//        "sender":"유저 이름" ,
//        "message":"as님이 입장하셨습다."
//        }
