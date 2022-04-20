package com.example.clonecoding.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class ChatMessage extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    Long id;

    @Column
    private MessageType type; // 메시지 타입

    @Column
    private String roomId; // 방번호

    @Column(nullable = false)
    private String sender; // 메시지 보낸사람

    @Column
    private String message; // 메시지

    @Column
    private String imageUrl; // 유저 프로필사진

    @ManyToOne
    private ChatRoom chatRoom; // 메시지
}