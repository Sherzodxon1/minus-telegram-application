package uz.minustelegramapplication.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.minustelegramapplication.dto.group.GroupCreateDTO;
import uz.minustelegramapplication.dto.group.GroupDTO;
import uz.minustelegramapplication.dto.group.GroupUpdateDTO;
import uz.minustelegramapplication.entity.Group;
import uz.minustelegramapplication.entity.User;
import uz.minustelegramapplication.enums.GroupType;
import uz.minustelegramapplication.mapper.GroupMapper;
import uz.minustelegramapplication.repo.GroupRepository;
import uz.minustelegramapplication.repo.UserRepository;
import uz.minustelegramapplication.response.ResponseData;
import uz.minustelegramapplication.service.GroupService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupServiceImpl implements GroupService {

    private final GroupRepository repo;

    private final GroupMapper mapper;

    private final UserRepository userRepository;

    @Override
    public ResponseEntity<ResponseData<List<GroupDTO>>> getAll() {
        List<Group> list = repo.findAll();
        List<GroupDTO> dtoList = new ArrayList<>();
        list.forEach(group -> dtoList.add(mapper.toDto(group)));
        return ResponseData.success200(dtoList);
    }

    @Override
    public ResponseEntity<ResponseData<GroupDTO>> get(Integer id) {
        Optional<Group> group = repo.findById(id);
        if (group.isEmpty()) {
            throw new RuntimeException("Group is not found !!!");
        }
        return ResponseData.success200(mapper.toDto(group.get()));
    }

    @Override
    public ResponseEntity<ResponseData<GroupDTO>> add(GroupCreateDTO dto) {
        Group group = mapper.toEntity(dto);

        Optional<User> user = userRepository.findById(dto.getOwnerId());

        if (user.isEmpty()) {
            return ResponseData.notFoundData("User is not found !!!");
        } else if (!user.get().isActive()) {
            return ResponseData.inActive("This User's status is inactive !!!");
        }

        if (GroupType.PRIVATE.equals(group.getGroupType())) {

            group.setUsername(null);
        } else {
            group.setUsername("@" + dto.getUsername());

        }

        repo.save(group);
        return ResponseData.success201(mapper.toDto(group));
    }

    @Override
    public ResponseEntity<ResponseData<GroupDTO>> edit(GroupUpdateDTO dto) {
        Optional<Group> optional = repo.findById(dto.getId());
        if (optional.isEmpty()) {
            throw new RuntimeException("Group is not found !!!");
        }
        Group group = mapper.toEntity(optional.get(), dto);

        if (GroupType.PRIVATE.equals(group.getGroupType())) {

            group.setUsername(null);
        } else {
            group.setUsername("@" + dto.getUsername());
        }

        repo.save(group);
        return ResponseData.success202(mapper.toDto(group));
    }

    @Override
    public ResponseEntity<ResponseData<GroupDTO>> getByName(String name) {
        Optional<Group> group = repo.findByUsername(name);
        if (group.isEmpty()) {
            throw new RuntimeException("Group is not found !!!");
        }
        return ResponseData.success200(mapper.toDto(group.get()));
    }

    @Override
    public Integer getCountGroup(Integer user_id) {
        return repo.getGroup(user_id);
    }

}
