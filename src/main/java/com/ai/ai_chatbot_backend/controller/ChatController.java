package com.ai.ai_chatbot_backend.controller;

import com.ai.ai_chatbot_backend.model.ChatRequest;
import com.ai.ai_chatbot_backend.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;

    @GetMapping("/test")
    public String getTest(){
        return "Test endpoint called!";
    }

    @PostMapping("/chat")
    public String chat(@RequestBody ChatRequest request){
        return chatService.getResponse(request.getMessage());
    }
}
