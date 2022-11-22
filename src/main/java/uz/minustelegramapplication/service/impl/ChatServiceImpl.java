package uz.minustelegramapplication.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.minustelegramapplication.dto.chatMessage.ChatDTO;
import uz.minustelegramapplication.entity.Chat;
import uz.minustelegramapplication.mapper.ChatMapper;
import uz.minustelegramapplication.repo.ChatRepository;
import uz.minustelegramapplication.response.ResponseData;
import uz.minustelegramapplication.service.ChatService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ChatServiceImpl implements ChatService {
    private final ChatRepository repository;

    private final ChatMapper mapper;

    @Override
    public ResponseEntity<ResponseData<List<ChatDTO>>> getAll() {
        List<Chat> list = repository.findAll();
        List<ChatDTO> dtoList = new ArrayList<>();
        list.forEach(chat -> dtoList.add(mapper.toDto(chat)));
        return ResponseData.success200(dtoList);
    }

    @Override
    public ResponseEntity<ResponseData<ChatDTO>> get(Integer id) {
        Optional<Chat> chat = repository.findById(id);
        if (chat.isEmpty()) {
            return  ResponseData.notFoundData("Group is not found !!!");
        }
        return ResponseData.success200(mapper.toDto(chat.get()));
    }
}
