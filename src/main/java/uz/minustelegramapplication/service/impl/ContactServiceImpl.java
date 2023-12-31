package uz.minustelegramapplication.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.minustelegramapplication.dto.contact.ContactCreateDTO;
import uz.minustelegramapplication.dto.contact.ContactDTO;
import uz.minustelegramapplication.entity.Contact;
import uz.minustelegramapplication.entity.User;
import uz.minustelegramapplication.mapper.ContactMapper;
import uz.minustelegramapplication.repo.ContactRepository;
import uz.minustelegramapplication.repo.UserRepository;
import uz.minustelegramapplication.response.ResponseData;
import uz.minustelegramapplication.service.ContactService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements ContactService {

    private final ContactRepository repo;
    private final ContactMapper mapper;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<ResponseData<List<ContactDTO>>> getAll() {
        List<Contact> list = repo.findAll();
        List<ContactDTO> dtoList = new ArrayList<>();
        list.forEach(contact -> dtoList.add(mapper.toDto(contact)));
        return ResponseData.success200(dtoList);
    }

    @Override
    public ResponseEntity<ResponseData<ContactDTO>> get(Integer id) {
        Optional<Contact> contact = repo.findById(id);
        if (contact.isEmpty()) {
            return ResponseData.notFoundData("Contact is not found !!!");
        }
        return ResponseData.success200(mapper.toDto(contact.get()));
    }

    @Override
    public ResponseEntity<ResponseData<ContactDTO>> add(ContactCreateDTO dto) {
        Contact contact = mapper.toEntity(dto);
        Optional<User> user = userRepository.findById(dto.getUserId());

        if (user.isEmpty()) {
            return ResponseData.notFoundData("User is not found !!!");
        } else if (!user.get().isActive()) {
            return ResponseData.inActive("This User's status is inactive !!!");
        }

        repo.save(contact);
        return ResponseData.success201(mapper.toDto(contact));
    }

    @Override
    public ResponseEntity<ResponseData<ContactDTO>> getByPhone(String phone) {
        return null;
    }

    @Override
    public ResponseEntity<ResponseData<ContactDTO>> getByName(String name) {
        return null;
    }

}
