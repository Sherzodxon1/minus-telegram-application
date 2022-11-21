package uz.minustelegramapplication.service;

import org.springframework.http.ResponseEntity;
import uz.minustelegramapplication.dto.UserCreateDTO;
import uz.minustelegramapplication.dto.UserDTO;
import uz.minustelegramapplication.dto.UserUpdateDTO;
import uz.minustelegramapplication.dto.channel.ChannelDTO;
import uz.minustelegramapplication.dto.chatMessage.ChatDTO;
import uz.minustelegramapplication.dto.group.GroupDTO;
import uz.minustelegramapplication.response.ResponseData;

import java.util.List;


public interface UserService {

    ResponseEntity<ResponseData<List<UserDTO>>> getAll();

    ResponseEntity<ResponseData<UserDTO>> get(Integer id);

    ResponseEntity<ResponseData<UserDTO>> add(UserCreateDTO dto);

    ResponseEntity<ResponseData<UserDTO>> edit(UserUpdateDTO dto);

    ResponseEntity<ResponseData<Boolean>> delete(Integer id);

    ResponseEntity<ResponseData<UserDTO>> getByPhone(String phone);

    ResponseEntity<ResponseData<UserDTO>> getByUserName(String name);

    ResponseEntity<ResponseData<UserDTO>> getLogin(String phone, String password);

    ResponseEntity<ResponseData<List<GroupDTO>>> getByUserId(Integer ownerId);
    ResponseEntity<ResponseData<List<ChatDTO>>> findByOwnerId(Integer id);

    ResponseEntity<ResponseData<List<ChannelDTO>>> getUserId(Integer userId);
}
