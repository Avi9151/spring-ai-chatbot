package com.avisoft.chatbot.spring_ai_chatbot.controller;

import com.avisoft.chatbot.spring_ai_chatbot.dto.ChatRequest;
import com.avisoft.chatbot.spring_ai_chatbot.service.AIChatService;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final AIChatService aiChatService;

    public ChatController(AIChatService aiChatService){
        this.aiChatService = aiChatService;
    }

    @PostMapping(value = "/stream",
            produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<String> streamResponse(@Valid @RequestBody ChatRequest chatRequest){
        return aiChatService.stream(chatRequest);
    }

}
