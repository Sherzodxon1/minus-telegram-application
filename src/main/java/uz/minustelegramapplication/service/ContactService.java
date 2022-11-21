package uz.minustelegramapplication.service;

import org.springframework.http.ResponseEntity;
import uz.minustelegramapplication.dto.contact.ContactCreateDTO;
import uz.minustelegramapplication.dto.contact.ContactDTO;
import uz.minustelegramapplication.response.ResponseData;

import java.util.List;

public interface ContactService {
    ResponseEntity<ResponseData<List<ContactDTO>>> getAll();

    ResponseEntity<ResponseData<ContactDTO>> get(Integer id);

    ResponseEntity<ResponseData<ContactDTO>> add(ContactCreateDTO dto);

    ResponseEntity<ResponseData<ContactDTO>> getByPhone(String phone);

    ResponseEntity<ResponseData<ContactDTO>> getByName(String name);
}
