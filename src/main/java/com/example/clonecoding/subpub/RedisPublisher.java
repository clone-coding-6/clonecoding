package com.example.clonecoding.subpub;

import com.example.clonecoding.dto.ChatMessageDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RedisPublisher {
    private final RedisTemplate<String, Object> redisTemplate;

    //채팅방에 입장하여 메세지를 작성하면 해당 메세지를 Redis Topic에 발행하는 기능의 서비스.
    //메세지가 발행하면 대기하고있떤 redis가 구독 서비스 메세지를 처리함.
    public void publish(ChannelTopic topic, ChatMessageDto message) {
        redisTemplate.convertAndSend(topic.getTopic(), message);
    }
}