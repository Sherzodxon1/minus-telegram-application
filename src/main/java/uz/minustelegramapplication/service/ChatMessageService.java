package uz.minustelegramapplication.service;

import org.springframework.http.ResponseEntity;
import uz.minustelegramapplication.dto.chatMessage.ChatMessageDTO;
import uz.minustelegramapplication.response.ResponseData;

public interface ChatMessageService {
    ResponseEntity<ResponseData<ChatMessageDTO>> getByChatId(Integer chatId);
}
