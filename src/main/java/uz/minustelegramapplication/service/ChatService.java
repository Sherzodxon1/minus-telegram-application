package uz.minustelegramapplication.service;

import org.springframework.http.ResponseEntity;
import uz.minustelegramapplication.dto.chatMessage.ChatDTO;
import uz.minustelegramapplication.response.ResponseData;

import java.util.List;

public interface ChatService  {
    ResponseEntity<ResponseData<List<ChatDTO>>> getAll();

    ResponseEntity<ResponseData<ChatDTO>> get(Integer id);
}
