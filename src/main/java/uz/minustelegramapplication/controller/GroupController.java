package uz.minustelegramapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.minustelegramapplication.base.BaseURI;
import uz.minustelegramapplication.dto.group.GroupCreateDTO;
import uz.minustelegramapplication.dto.group.GroupDTO;
import uz.minustelegramapplication.dto.group.GroupUpdateDTO;
import uz.minustelegramapplication.response.ResponseData;
import uz.minustelegramapplication.service.GroupService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API + BaseURI.V1 + BaseURI.GROUP)
public class GroupController {

    private final GroupService service;

    @GetMapping(BaseURI.GET + BaseURI.ALL)
    public ResponseEntity<ResponseData<List<GroupDTO>>> getAll() {
        return service.getAll();
    }

    @GetMapping(BaseURI.GET + "/{id}")
    public ResponseEntity<ResponseData<GroupDTO>> get(@PathVariable(value = "id") Integer id) {
        return service.get(id);
    }

    @PostMapping(BaseURI.ADD)
    public ResponseEntity<ResponseData<GroupDTO>> add(@Valid @RequestBody GroupCreateDTO dto) {
        return service.add(dto);
    }

    @PutMapping(BaseURI.EDIT)
    public ResponseEntity<ResponseData<GroupDTO>> edit(@Valid @RequestBody GroupUpdateDTO dto) {
        return service.edit(dto);
    }

    @GetMapping(BaseURI.USERNAME + "/{name}")
    public ResponseEntity<ResponseData<GroupDTO>> searchByUsername(@PathVariable(value = "name") String name) {
        return service.getByName(name);
    }

    @GetMapping(BaseURI.USER_FIND + "/{userId}")
    public ResponseEntity<ResponseData<GroupDTO>> searchByUsername(@PathVariable(value = "userId") Integer id) {
        return service.getByUserId(id);
    }

}
