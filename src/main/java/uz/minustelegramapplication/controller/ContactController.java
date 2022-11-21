package uz.minustelegramapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.minustelegramapplication.base.BaseURI;
import uz.minustelegramapplication.dto.contact.ContactCreateDTO;
import uz.minustelegramapplication.dto.contact.ContactDTO;
import uz.minustelegramapplication.response.ResponseData;
import uz.minustelegramapplication.service.ContactService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API + BaseURI.V1 + BaseURI.CONTACT)
public class ContactController {

    private final ContactService service;

    @GetMapping(BaseURI.GET + BaseURI.ALL)
    public ResponseEntity<ResponseData<List<ContactDTO>>> getAll() {
        return service.getAll();
    }

    @GetMapping(BaseURI.GET + "/{id}")
    public ResponseEntity<ResponseData<ContactDTO>> get(@PathVariable(value = "id") Integer id) {
        return service.get(id);
    }

    @PostMapping(BaseURI.ADD)
    public ResponseEntity<ResponseData<ContactDTO>> add(@Valid @RequestBody ContactCreateDTO dto) {
        return service.add(dto);
    }

    @GetMapping(BaseURI.PHONE + "/{phone}")
    public ResponseEntity<ResponseData<ContactDTO>> searchByPhone(@PathVariable(value = "phone") String phone) {
        return service.getByPhone(phone);
    }

    @GetMapping(BaseURI.NAME + "/{name}")
    public ResponseEntity<ResponseData<ContactDTO>> searchByName(@PathVariable(value = "name") String name) {
        return service.getByName(name);
    }

}
