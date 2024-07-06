package com.example.ollamachatdemo;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ChatController {

    private final ChatClient chatClient;

    public ChatController(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @GetMapping("prompt")
    public String prompt(@RequestParam("text") String text) {
        return chatClient.prompt()
                .user(text)
                .call()
                .content();
    }

    @GetMapping("stream/prompt")
    public Flux<String> fluxPrompt(@RequestParam("text") String text) {
        return chatClient.prompt()
                .user(text)
                .stream()
                .content();
    }
}
