package uz.minustelegramapplication.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.minustelegramapplication.dto.UserCreateDTO;
import uz.minustelegramapplication.dto.UserDTO;
import uz.minustelegramapplication.dto.UserUpdateDTO;
import uz.minustelegramapplication.entity.User;
import uz.minustelegramapplication.mapper.UserMapper;
import uz.minustelegramapplication.repo.UserRepository;
import uz.minustelegramapplication.response.ResponseData;
import uz.minustelegramapplication.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final UserMapper mapper;


    @Override
    public ResponseEntity<ResponseData<List<UserDTO>>> getAll() {
        List<User> list = repository.findAll();
        List<UserDTO> dtoList = new ArrayList<>();
        list.forEach(user -> dtoList.add(mapper.toDto(user)));
        return ResponseData.success200(dtoList);
    }

    @Override
    public ResponseEntity<ResponseData<UserDTO>> get(Integer id) {
        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User is not found !!!");
        }
        return ResponseData.success200(mapper.toDto(userOptional.get()));

    }


    @Override
    public ResponseEntity<ResponseData<UserDTO>> add(UserCreateDTO dto) {
        User user = mapper.toEntity(dto);
        repository.save(user);
        return ResponseData.success201(mapper.toDto(user));

    }

    @Override
    public ResponseEntity<ResponseData<UserDTO>> edit(UserUpdateDTO dto) {
        Optional<User> userOptional = repository.findById(dto.getId());
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User is not found !!!");
        }
        User user = mapper.toEntity(userOptional.get(), dto);
        repository.save(user);
        return ResponseData.success202(mapper.toDto(user));

    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(Integer id) {

        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User is not found !!!");
        }
        repository.delete(userOptional.get());
        return ResponseData.success200(true);

    }


}