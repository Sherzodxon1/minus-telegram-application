package uz.minustelegramapplication.service;

import org.springframework.http.ResponseEntity;
import uz.minustelegramapplication.dto.chatMessage.ChatMessageDTO;
import uz.minustelegramapplication.response.ResponseData;

import java.util.List;

public interface ChatMessageService {

    ResponseEntity<ResponseData<List<ChatMessageDTO>>> getChatId(Integer chatId);
}
