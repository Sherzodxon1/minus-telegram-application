package uz.minustelegramapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uz.minustelegramapplication.base.BaseURI;
import uz.minustelegramapplication.dto.channel.ChannelCreateDTO;
import uz.minustelegramapplication.dto.channel.ChannelDTO;
import uz.minustelegramapplication.dto.channel.ChannelUpdateDTO;
import uz.minustelegramapplication.response.ResponseData;
import uz.minustelegramapplication.service.ChannelService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API + BaseURI.V1 + BaseURI.CHANNEL)
public class ChannelController {

    private final ChannelService service;

    @GetMapping(BaseURI.GET + BaseURI.ALL)
    public ResponseEntity<ResponseData<List<ChannelDTO>>> getAll() {
        return service.getAll();
    }

    @GetMapping(BaseURI.GET + "/{id}")
    public ResponseEntity<ResponseData<ChannelDTO>> get(@PathVariable(value = "id") Integer id) {
        return service.get(id);
    }

    @PostMapping(BaseURI.ADD)
    public ResponseEntity<ResponseData<ChannelDTO>> add(@Valid @RequestBody ChannelCreateDTO dto) {
        return service.add(dto);
    }

    @PutMapping(BaseURI.EDIT)
    public ResponseEntity<ResponseData<ChannelDTO>> edit(@Valid @RequestBody ChannelUpdateDTO dto) {
        return service.edit(dto);
    }

    @GetMapping(BaseURI.USERNAME + "/{name}")
    public ResponseEntity<ResponseData<ChannelDTO>> searchByUsername(@PathVariable(value = "name") String name) {
        return service.getByName(name);
    }

}
