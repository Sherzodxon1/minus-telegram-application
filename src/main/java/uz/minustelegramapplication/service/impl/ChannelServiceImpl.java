package uz.minustelegramapplication.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import uz.minustelegramapplication.base.BaseURI;
import uz.minustelegramapplication.dto.channel.ChannelCreateDTO;
import uz.minustelegramapplication.dto.channel.ChannelDTO;
import uz.minustelegramapplication.dto.channel.ChannelUpdateDTO;
import uz.minustelegramapplication.entity.Channel;
import uz.minustelegramapplication.enums.ChannelType;
import uz.minustelegramapplication.mapper.ChannelMapper;
import uz.minustelegramapplication.repo.ChannelRepository;
import uz.minustelegramapplication.response.ResponseData;
import uz.minustelegramapplication.service.ChannelService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
@RequiredArgsConstructor
public class ChannelServiceImpl implements ChannelService {

    private final ChannelRepository repo;
    private final ChannelMapper mapper;

    @Override
    public ResponseEntity<ResponseData<List<ChannelDTO>>> getAll() {
        List<Channel> list = repo.findAll();
        List<ChannelDTO> dtoList = new ArrayList<>();
        list.forEach(channel -> dtoList.add(mapper.toDto(channel)));
        return ResponseData.success200(dtoList);
    }

    @Override
    public ResponseEntity<ResponseData<ChannelDTO>> get(Integer id) {
        Optional<Channel> channel = repo.findById(id);
        if (channel.isEmpty()) {
            ResponseData.notFoundData("Channel is not found !!!");
        }
        return ResponseData.success200(mapper.toDto(channel.get()));
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    @Override
    public ResponseEntity<ResponseData<ChannelDTO>> add(ChannelCreateDTO dto) {
        Channel channel = mapper.toEntity(dto);

        if (ChannelType.PRIVATE.equals(channel.getChannelType())) {

            channel.setUsername(null);
            channel.setLink(BaseURI.TME + "+" + channel.getUuid().toString().substring(0, 16));

        } else {
            channel.setUsername("@" + dto.getUsername());
        }

        repo.save(channel);

        Integer channelId = channel.getId();
        Channel saved = repo.findById(channelId).get();

        return ResponseData.success201(mapper.toDto(saved));
    }

    @Override
    public ResponseEntity<ResponseData<ChannelDTO>> edit(ChannelUpdateDTO dto) {
        Optional<Channel> optional = repo.findById(dto.getId());
        if (optional.isEmpty()) {
            ResponseData.notFoundData("Channel is not found !!!");
        }
        Channel channel = mapper.toEntity(optional.get(), dto);
        repo.save(channel);
        return ResponseData.success202(mapper.toDto(channel));
    }

    @Override
    public ResponseEntity<ResponseData<ChannelDTO>> getByName(String name) {
        Optional<Channel> channel = repo.findByName(name);
        if (channel.isEmpty()) {
            ResponseData.notFoundData("Channel is not found !!!");
        }
        return ResponseData.success200(mapper.toDto(channel.get()));
    }
}
