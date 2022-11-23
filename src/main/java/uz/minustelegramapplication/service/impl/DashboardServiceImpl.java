package uz.minustelegramapplication.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.minustelegramapplication.entity.Channel;
import uz.minustelegramapplication.entity.Group;
import uz.minustelegramapplication.repo.ChannelRepository;
import uz.minustelegramapplication.repo.GroupRepository;
import uz.minustelegramapplication.response.ResponseData;
import uz.minustelegramapplication.service.ChannelService;
import uz.minustelegramapplication.service.DashboardService;
import uz.minustelegramapplication.service.GroupService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final ChannelRepository channelRepository;
    private final ChannelService service;
    private final GroupRepository groupRepository;
    private final GroupService groupService;

    @Override
    public ResponseEntity<ResponseData<Integer>> getChannel(Integer id) {
        Optional<Channel> channel = channelRepository.findById(id);
        if (channel.isEmpty()) {
            return ResponseData.notFoundData("Channel is not found !!!");
        }
        return ResponseData.success200(service.getCount(id));
    }

    @Override
    public ResponseEntity<ResponseData<Integer>> getGroup(Integer id) {
        Optional<Group> group = groupRepository.findById(id);
        if (group.isEmpty()) {
            return ResponseData.notFoundData("Group is not found !!!");
        }

        return ResponseData.success200(groupService.getCountGroup(id));
    }
}
