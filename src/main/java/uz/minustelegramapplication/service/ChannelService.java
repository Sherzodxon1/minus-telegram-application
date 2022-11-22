package uz.minustelegramapplication.service;

import org.springframework.http.ResponseEntity;
import uz.minustelegramapplication.dto.channel.ChannelCreateDTO;
import uz.minustelegramapplication.dto.channel.ChannelDTO;
import uz.minustelegramapplication.dto.channel.ChannelUpdateDTO;
import uz.minustelegramapplication.response.ResponseData;

import java.util.List;

public interface ChannelService {

    ResponseEntity<ResponseData<List<ChannelDTO>>> getAll();

    ResponseEntity<ResponseData<ChannelDTO>> get(Integer id);

    ResponseEntity<ResponseData<ChannelDTO>> add(ChannelCreateDTO dto);

    ResponseEntity<ResponseData<ChannelDTO>> edit(ChannelUpdateDTO dto);

    ResponseEntity<ResponseData<ChannelDTO>> getByName(String name);

    ResponseEntity<ResponseData<ChannelDTO>> delete(Integer id);

    Integer getCount(Integer userId);
}
