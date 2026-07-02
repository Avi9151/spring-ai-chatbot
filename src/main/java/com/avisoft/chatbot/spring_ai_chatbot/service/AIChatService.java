package com.avisoft.chatbot.spring_ai_chatbot.service;

import com.avisoft.chatbot.spring_ai_chatbot.dto.ChatRequest;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class AIChatService {

    private final ChatClient chatClient;

    public AIChatService(ChatClient chatClient){
        this.chatClient = chatClient;
    }

    public String ask(ChatRequest request){
        return chatClient
                .prompt(request.message())
                .call()
                .content();
    }

    //Streaming the Text
//    public Flux<String> ask(ChatRequest request) {
//        return chatClient
//                .prompt(request.message())
//                .stream()
//                .content();
//    }
}
