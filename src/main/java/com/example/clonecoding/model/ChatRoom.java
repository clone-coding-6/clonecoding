package com.example.clonecoding.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
public class ChatRoom implements Serializable {

    private static final long serialVersionUID = 6494678977089006639L;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long chatRoomId;

    @Column
    private String roomId;

    @Column
    private String name;

    @OneToMany
    private List<ChatMessage> chatMessage;

}
