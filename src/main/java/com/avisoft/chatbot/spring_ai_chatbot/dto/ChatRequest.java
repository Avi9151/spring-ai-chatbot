package com.avisoft.chatbot.spring_ai_chatbot.dto;

import jakarta.validation.constraints.NotBlank;

public record ChatRequest(
        @NotBlank(message = "Message can not be empty")
        String message) {
}
