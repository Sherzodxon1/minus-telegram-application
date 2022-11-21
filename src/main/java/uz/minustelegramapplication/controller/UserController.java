package uz.minustelegramapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.minustelegramapplication.base.BaseURI;
import uz.minustelegramapplication.dto.UserCreateDTO;
import uz.minustelegramapplication.dto.UserDTO;
import uz.minustelegramapplication.dto.channel.ChannelDTO;
import uz.minustelegramapplication.dto.chatMessage.ChatDTO;
import uz.minustelegramapplication.dto.group.GroupDTO;
import uz.minustelegramapplication.response.ResponseData;
import uz.minustelegramapplication.service.UserService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API + BaseURI.V1 + BaseURI.USER)
public class UserController {

    private final UserService service;

    @GetMapping(BaseURI.GET + BaseURI.ALL)
    public ResponseEntity<ResponseData<List<UserDTO>>> getAll() {
        return service.getAll();
    }

    @GetMapping(BaseURI.GET + "/{id}")
    public ResponseEntity<ResponseData<UserDTO>> get(@PathVariable(value = "id") Integer id) {
        return service.get(id);
    }

    @PostMapping(BaseURI.ADD)
    public ResponseEntity<ResponseData<UserDTO>> add(@Valid @RequestBody UserCreateDTO dto) {
        return service.add(dto);
    }


    @GetMapping(BaseURI.PHONE + "/{phone}")
    public ResponseEntity<ResponseData<UserDTO>> searchByPhone(@PathVariable(value = "phone") String phone) {
        return service.getByPhone(phone);
    }

    @GetMapping(BaseURI.USERNAME + "/{name}")
    public ResponseEntity<ResponseData<UserDTO>> searchByUserName(@PathVariable(value = "name") String name) {
        return service.getByUserName(name);
    }
    @GetMapping(BaseURI.GROUP_BY_ID + "/{groupById}")
    public ResponseEntity<ResponseData<List<GroupDTO>>> getUserId(@PathVariable(value = "groupById") Integer ownerId) {
        return service.getByUserId(ownerId);
    }

    @GetMapping(BaseURI.CHAT_BY_ID + "/{chatById}")
    public ResponseEntity<ResponseData<List<ChatDTO>>> getOwnerId(@PathVariable(value = "chatById") Integer id) {
        return service.findByOwnerId(id);
    }

    @GetMapping(BaseURI.CHANNEL_BY_ID + "/{channelByUserId}")
    public ResponseEntity<ResponseData<List<ChannelDTO>>> getByOwnerId(@PathVariable(value = "channelByUserId") Integer ownerId) {
        return service.getUserId(ownerId);
    }
}
