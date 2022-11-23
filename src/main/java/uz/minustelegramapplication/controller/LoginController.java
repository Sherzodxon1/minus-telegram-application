package uz.minustelegramapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.minustelegramapplication.base.BaseURI;
import uz.minustelegramapplication.dto.UserDTO;
import uz.minustelegramapplication.response.ResponseData;
import uz.minustelegramapplication.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API + BaseURI.V1 + BaseURI.LOGIN)
public class LoginController {

    private final UserService service;

    @GetMapping()
    public ResponseEntity<ResponseData<UserDTO>> login(@RequestParam(value = "phone") String  phone,
                                                     @RequestParam(value = "password") String password) {
        return service.getLogin(phone, password);
    }
}
