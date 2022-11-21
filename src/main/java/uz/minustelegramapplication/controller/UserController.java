package uz.minustelegramapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.minustelegramapplication.base.BaseURI;
import uz.minustelegramapplication.dto.UserCreateDTO;
import uz.minustelegramapplication.dto.UserDTO;
import uz.minustelegramapplication.dto.UserUpdateDTO;
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

    @PutMapping(BaseURI.EDIT)
    public ResponseEntity<ResponseData<UserDTO>> edit(@Valid @RequestBody UserUpdateDTO dto) {
        return service.edit(dto);
    }

    @GetMapping(BaseURI.PHONE + "/{phone}")
    public ResponseEntity<ResponseData<UserDTO>> searchByPhone(@PathVariable(value = "phone") String phone) {
        return service.getByPhone(phone);
    }

    @GetMapping(BaseURI.USERNAME + "/{name}")
    public ResponseEntity<ResponseData<UserDTO>> searchByUserName(@PathVariable(value = "name") String name) {
        return service.getByUserName(name);
    }

}
