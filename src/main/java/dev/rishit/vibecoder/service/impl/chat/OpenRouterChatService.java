package dev.rishit.vibecoder.service.impl.chat;

import dev.rishit.vibecoder.service.chat.ChatModelService;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OpenRouterChatService implements ChatModelService {

    private final ChatModel chatModel;

    @Override
    public String generateResponse(String message) {
        return null;
    }
}