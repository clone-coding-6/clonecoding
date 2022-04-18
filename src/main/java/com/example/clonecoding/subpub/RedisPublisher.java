package com.example.clonecoding.subpub;

import com.example.clonecoding.dto.ChatMessageDto;
import com.example.clonecoding.model.ChatMessage;
import com.example.clonecoding.model.ChatRoom;
import com.example.clonecoding.repository.ChatMessageRepository;
import com.example.clonecoding.repository.ChatRoomRepository;
import com.example.clonecoding.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class RedisPublisher {
    private final RedisTemplate<String, Object> redisTemplate;
    private final UserRepository userRepository;
    private final ChatMessageRepository chatMessageRepository;

    private final ChatRoomRepository chatRoomRepository;

    //채팅방에 입장하여 메세지를 작성하면 해당 메세지를 Redis Topic에 발행하는 기능의 서비스.
    //메세지가 발행하면 대기하고있떤 redis가 구독 서비스 메세지를 처리함.
    public void publish(ChannelTopic topic, ChatMessageDto.Request message) {
//        User user = userRepository.findByNickname(message.getSender()).orElseThrow(
//                () -> new MessageDeliveryException("유효한 회원이 존재하지 않습니다.")
//        );
        log.info(String.valueOf(message));
        ChatRoom chatRoom = chatRoomRepository.findRoomById(message.getRoomId());
        ChatMessage chatMessage = ChatMessage.builder()
                .roomId(message.getRoomId())
                .type(message.getType())
                .sender(message.getSender())
                .message(message.getMessage())
//                .imageUrl(user.getImageUrl())
                .chatRoom(chatRoom)
                .build();
        chatMessageRepository.save(chatMessage);
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}