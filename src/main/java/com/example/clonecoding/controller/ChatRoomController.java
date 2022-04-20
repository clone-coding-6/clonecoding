package com.example.clonecoding.controller;

import com.example.clonecoding.dto.ChatMessagedResponseDto;
import com.example.clonecoding.model.ChatRoom;
import com.example.clonecoding.repository.ChatRoomJpaRepository;
import com.example.clonecoding.repository.ChatRoomRepository;
import com.example.clonecoding.service.ChatRoomService;
import com.example.clonecoding.service.ChatSerivce;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@Controller
@RequestMapping("/chat")
public class ChatRoomController {
    private final ChatRoomService chatRoomService;
    private final ChatSerivce chatSerivce;
    private final ChatRoomRepository chatRoomRepository;

    private final ChatRoomJpaRepository chatRoomJpaRepository;

    @GetMapping("room/enter/{roomId}")
    public String roomDetail(Model model, @PathVariable String roomId) {
        model.addAttribute("roomId", roomId);
        return "/chat/roomdetail";
    }

    // 모든 채팅방 목록 반환
    @GetMapping("/listlookup")
    @ResponseBody
    public List<ChatRoom> room() {
        return chatRoomJpaRepository.findAll();
    }

    // 채팅 리스트 화면
    @GetMapping("/room")
    public String rooms(Model model) {
        return "/chat/room";
    }

    // 채팅방 생성
    @PostMapping("/createroom")
    @ResponseBody
    public ChatRoom createRoom(@RequestParam String name){
        return chatRoomService.createRoom(name);
    }

    //특정 채팅방 삭제
    @DeleteMapping("/delete/{roomId}")
    @ResponseBody
    public void roomDelete(@PathVariable String roomId) {
        chatRoomService.delete(roomId);
    }

    //채팅방 내역조회
    @GetMapping("/message/{roomid}")
    @ResponseBody
    public List<ChatMessagedResponseDto> subMessage(@PathVariable String roomid){
        return chatSerivce.subMessage(roomid);
    }

    // 특정 채팅방 조회 (추가기능)
    @GetMapping("/listlookup/{roomid}")
    @ResponseBody
    public ChatRoom roomInfo(@PathVariable String roomid) {
        return chatRoomRepository.findRoomById(roomid);
    }



    //    @GetMapping("/room/{roomId}")
//    @ResponseBody
//    public ChatRoom roomInfo(@PathVariable String roomId) {
//        return chatRoomRepository.findRoomById(roomId);
//    }

//    //특정 채팅방 삭제
//    @DeleteMapping("/delete/{roomid}")
//    public String roomDelete(@PathVariable String roomid) {
//        chatRoomJPARepository.deleteByRoomId(roomid);
//        return roomid;
//    }

}