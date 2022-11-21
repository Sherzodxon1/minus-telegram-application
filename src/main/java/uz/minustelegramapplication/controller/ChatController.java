package uz.minustelegramapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.minustelegramapplication.base.BaseURI;
import uz.minustelegramapplication.dto.chatMessage.ChatDTO;
import uz.minustelegramapplication.dto.group.GroupDTO;
import uz.minustelegramapplication.response.ResponseData;
import uz.minustelegramapplication.service.ChatService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API + BaseURI.V1 + BaseURI.CHAT)
public class ChatController {

    private final ChatService service;

    @GetMapping(BaseURI.GET + BaseURI.ALL)
    public ResponseEntity<ResponseData<List<ChatDTO>>> getAll() {
        return service.getAll();
    }

    @GetMapping(BaseURI.GET + "/{id}")
    public ResponseEntity<ResponseData<ChatDTO>> get(@PathVariable(value = "id") Integer id) {
        return service.get(id);
    }
}
