package uz.minustelegramapplication.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.minustelegramapplication.dto.UserCreateDTO;
import uz.minustelegramapplication.dto.UserDTO;
import uz.minustelegramapplication.dto.UserUpdateDTO;
import uz.minustelegramapplication.dto.channel.ChannelDTO;
import uz.minustelegramapplication.dto.chatMessage.ChatDTO;
import uz.minustelegramapplication.dto.group.GroupDTO;
import uz.minustelegramapplication.entity.Channel;
import uz.minustelegramapplication.entity.Chat;
import uz.minustelegramapplication.entity.Group;
import uz.minustelegramapplication.entity.User;
import uz.minustelegramapplication.mapper.ChannelMapper;
import uz.minustelegramapplication.mapper.ChatMapper;
import uz.minustelegramapplication.mapper.GroupMapper;
import uz.minustelegramapplication.mapper.UserMapper;
import uz.minustelegramapplication.repo.ChannelRepository;
import uz.minustelegramapplication.repo.ChatRepository;
import uz.minustelegramapplication.repo.GroupRepository;
import uz.minustelegramapplication.repo.UserRepository;
import uz.minustelegramapplication.response.ResponseData;
import uz.minustelegramapplication.service.ContactService;
import uz.minustelegramapplication.service.FileService;
import uz.minustelegramapplication.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;
    private final GroupRepository groupRepository;

    private final ChatRepository chatRepository;

    private final ChannelRepository channelRepository;
    private final GroupMapper groupMapper;

    private final UserMapper mapper;

    private final ChatMapper chatMapper;

    private final ChannelMapper channelMapper;
    private final FileService fileService;


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
            return  ResponseData.notFoundData("User is not found !!!");
        }
        return ResponseData.success200(mapper.toDto(userOptional.get()));

    }


    @Override
    public ResponseEntity<ResponseData<UserDTO>> add(UserCreateDTO dto) {
        User user = mapper.toEntity(dto);
        repository.save(user);
        fileService.attachUser(dto.getFileIds(), user.getId());
        return ResponseData.success201(mapper.toDto(user));

    }

    @Override
    public ResponseEntity<ResponseData<UserDTO>> edit(UserUpdateDTO dto) {
        Optional<User> userOptional = repository.findById(dto.getId());
        if (userOptional.isEmpty()) {
            return  ResponseData.notFoundData("User is not found !!!");
        }
        User user = mapper.toEntity(userOptional.get(), dto);
        repository.save(user);
        return ResponseData.success202(mapper.toDto(user));

    }

    @Override
    public ResponseEntity<ResponseData<Boolean>> delete(Integer id) {

        Optional<User> userOptional = repository.findById(id);
        if (userOptional.isEmpty()) {
            return  ResponseData.notFoundData("User is not found !!!");
        }
        repository.delete(userOptional.get());
        return ResponseData.success200(true);

    }

    @Override
    public ResponseEntity<ResponseData<UserDTO>> getByPhone(String phone) {
        Optional<User> userOptional = repository.findByPhone(phone);
        if (userOptional.isEmpty()) {
            return  ResponseData.notFoundData("User is not found !!!");
        }
        return ResponseData.success200(mapper.toDto(userOptional.get()));

    }

    @Override
    public ResponseEntity<ResponseData<UserDTO>> getByUserName(String name) {
        Optional<User> userOptional = repository.findByUserName(name);
        if (userOptional.isEmpty()) {
            return  ResponseData.notFoundData("User is not found !!!");
        }
        return ResponseData.success200(mapper.toDto(userOptional.get()));
    }

    @Override
    public ResponseEntity<ResponseData<UserDTO>> getLogin(String phone, String password) {
        Optional<User> user = repository.findByPhoneAndPassword(phone, password);
        if (user.isEmpty()) {
//            throw new RuntimeException("User is not found !!!");
            return  ResponseData.notFoundData("User is not found !!!");
        }
        return ResponseData.success200(mapper.toDto(user.get()));
    }

    @Override
    public ResponseEntity<ResponseData<List<GroupDTO>>> getByUserId(Integer id) {
        List<Group> list = groupRepository.findByOwnerId(id);
        List<GroupDTO> dtoList = new ArrayList<>();
        list.forEach(group -> dtoList.add(groupMapper.toDto(group)));
        return ResponseData.success200(dtoList);
    }

    @Override
    public ResponseEntity<ResponseData<List<ChatDTO>>> findByOwnerId(Integer id) {
        List<Chat> list = chatRepository.findChatById(id);
        List<ChatDTO> dtoList = new ArrayList<>();
        list.forEach(chat -> dtoList.add(chatMapper.toDto(chat)));
        return ResponseData.success200(dtoList);


    }

    @Override
    public ResponseEntity<ResponseData<List<ChannelDTO>>> getUserId(Integer id) {
        List<Channel> list = channelRepository.findByOwnerId(id);
        List<ChannelDTO> dtoList = new ArrayList<>();
        list.forEach(channel -> dtoList.add(channelMapper.toDto(channel)));
        return ResponseData.success200(dtoList);
    }
}
