package uz.minustelegramapplication.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.minustelegramapplication.dto.chatMessage.ChatMessageDTO;
import uz.minustelegramapplication.entity.ChatMessage;
import uz.minustelegramapplication.mapper.ChatMessageMapper;
import uz.minustelegramapplication.repo.ChatMessageRepository;
import uz.minustelegramapplication.response.ResponseData;
import uz.minustelegramapplication.service.ChatMessageService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository repository;

    private final ChatMessageMapper mapper;

    @Override
    public ResponseEntity<ResponseData<ChatMessageDTO>> getByChatId(Integer chatId) {
        Optional<ChatMessage> chatMessageOptional = repository.findByChatId(chatId);
        if (chatMessageOptional.isEmpty()) {
            throw new RuntimeException("User is not found !!!");
        }
        return ResponseData.success200(mapper.toDto(chatMessageOptional.get()));
    }


}
