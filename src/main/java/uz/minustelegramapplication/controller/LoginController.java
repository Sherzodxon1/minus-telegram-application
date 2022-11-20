package uz.minustelegramapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uz.minustelegramapplication.base.BaseURI;
import uz.minustelegramapplication.dto.UserDTO;
import uz.minustelegramapplication.response.ResponseData;
import uz.minustelegramapplication.service.UserService;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API + BaseURI.V1 + BaseURI.LOGIN)
public class LoginController {

    private final UserService service;

    @GetMapping(BaseURI.GET + "/{phone}" + "/{password}")
    public ResponseEntity<ResponseData<UserDTO>> get(@PathVariable(value = "phone") String  phone,
                                                     @PathVariable(value = "password") String password) {
        return service.getLogin(phone, password);
    }
}
