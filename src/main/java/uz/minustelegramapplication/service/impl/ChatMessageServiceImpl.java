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

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ChatMessageServiceImpl implements ChatMessageService {

    private final ChatMessageRepository repository;

    private final ChatMessageMapper mapper;

    @Override
    public ResponseEntity<ResponseData<List<ChatMessageDTO>>> getChatId(Integer chatId) {
        List<ChatMessage> list = repository.findByChatId(chatId);
        List<ChatMessageDTO> dtoList = new ArrayList<>();
        list.forEach(chatMessage -> dtoList.add(mapper.toDto(chatMessage)));
        return ResponseData.success200(dtoList);
    }


}
