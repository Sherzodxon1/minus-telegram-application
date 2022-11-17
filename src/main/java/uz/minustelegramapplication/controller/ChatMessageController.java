package uz.minustelegramapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.minustelegramapplication.base.BaseURI;
import uz.minustelegramapplication.dto.chatMessage.ChatMessageDTO;
import uz.minustelegramapplication.response.ResponseData;
import uz.minustelegramapplication.service.ChatMessageService;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API + BaseURI.V1 + BaseURI.CHATMESSAGE)
public class ChatMessageController {

    private final ChatMessageService service;

    @GetMapping(BaseURI.CHAT_ID + "/{chatId}")
    public ResponseEntity<ResponseData<ChatMessageDTO>> findByChatId(@PathVariable(value = "chatId") Integer chatId) {
        return service.getByChatId(chatId);
    }
}
