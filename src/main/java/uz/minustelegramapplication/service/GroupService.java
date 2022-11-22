package uz.minustelegramapplication.service;

import org.springframework.http.ResponseEntity;
import uz.minustelegramapplication.dto.group.GroupCreateDTO;
import uz.minustelegramapplication.dto.group.GroupDTO;
import uz.minustelegramapplication.dto.group.GroupUpdateDTO;
import uz.minustelegramapplication.response.ResponseData;

import java.util.List;

public interface GroupService {

    ResponseEntity<ResponseData<List<GroupDTO>>> getAll();

    ResponseEntity<ResponseData<GroupDTO>> get(Integer id);

    ResponseEntity<ResponseData<GroupDTO>> add(GroupCreateDTO dto);

    ResponseEntity<ResponseData<GroupDTO>> edit(GroupUpdateDTO dto);

    ResponseEntity<ResponseData<GroupDTO>> getByName(String name);

    Integer getCountGroup(Integer user_id);
}
