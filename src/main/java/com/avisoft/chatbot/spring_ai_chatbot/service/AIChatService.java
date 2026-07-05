package com.avisoft.chatbot.spring_ai_chatbot.service;

import com.avisoft.chatbot.spring_ai_chatbot.dto.ChatRequest;
import com.avisoft.chatbot.spring_ai_chatbot.prompt.PromptTemplates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class AIChatService {

    private static final Logger log = LoggerFactory.getLogger(AIChatService.class);
    private final ChatClient chatClient;

    public AIChatService(ChatClient chatClient){
        this.chatClient = chatClient;
    }

    public Flux<String> stream(ChatRequest request){

        String prompt = PromptTemplates.JAVA_MENTOR
                .formatted(request.message());

        try {
            return chatClient
                    .prompt(prompt)
                    .stream()
                    .content();
        }
        catch (Exception ex){
            log.error("AI request failed", ex);
            throw new RuntimeException("Unable to process AI request.");
        }
    }

}
