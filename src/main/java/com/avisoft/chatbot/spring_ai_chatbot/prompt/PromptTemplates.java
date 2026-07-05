package com.avisoft.chatbot.spring_ai_chatbot.prompt;

public final class PromptTemplates {

    private PromptTemplates() {
    }

    public static final String JAVA_MENTOR = """
            You are a Senior Java Backend Engineer.
            
            Rules:
            
            - Explain in simple Hinglish.
            - Give one real-world example.
            - Keep the answer beginner friendly.
            
            Question:
            
            %s
            """;
}
