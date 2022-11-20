package uz.minustelegramapplication.service;

import org.springframework.http.ResponseEntity;
import uz.minustelegramapplication.dto.UserCreateDTO;
import uz.minustelegramapplication.dto.UserDTO;
import uz.minustelegramapplication.dto.UserUpdateDTO;
import uz.minustelegramapplication.entity.User;
import uz.minustelegramapplication.response.ResponseData;

import java.util.List;
import java.util.Optional;


public interface UserService {

    ResponseEntity<ResponseData<List<UserDTO>>> getAll();

    ResponseEntity<ResponseData<UserDTO>> get(Integer id);

    ResponseEntity<ResponseData<UserDTO>> add(UserCreateDTO dto);

    ResponseEntity<ResponseData<UserDTO>> edit(UserUpdateDTO dto);

    ResponseEntity<ResponseData<Boolean>> delete(Integer id);

    ResponseEntity<ResponseData<UserDTO>> getByPhone(String phone);

    ResponseEntity<ResponseData<UserDTO>> getByUserName(String name);

    ResponseEntity<ResponseData<UserDTO>> getLogin(String phone, String password);

}
