package com.practice;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequiredArgsConstructor 
@RestController 
public class ChatController {
    private final ChatClient chatClient;

    @GetMapping("/")
    public String askSomething(@RequestParam String param) {
        return chatClient.prompt()
        .system("You are .....")
        .user("Hi" + param)
        .options(OpenAiChatOptions.builder()
            .model("gpt-4o-mini")
            .maxTokens(100))
        .advisors()
        .call()
        .content();
    }
}    
