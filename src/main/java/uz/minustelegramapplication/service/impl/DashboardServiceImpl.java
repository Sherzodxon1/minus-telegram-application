package uz.minustelegramapplication.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.minustelegramapplication.response.ResponseData;
import uz.minustelegramapplication.service.ChannelService;
import uz.minustelegramapplication.service.DashboardService;
import uz.minustelegramapplication.service.GroupService;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final ChannelService service;

    private final GroupService groupService;
    @Override
    public ResponseEntity<ResponseData<Integer>> getCount(Integer user_id) {
        return ResponseData.success200(service.getCount(user_id));
    }

    @Override
    public ResponseEntity<ResponseData<Integer>> getGroup(Integer user_id) {
        return ResponseData.success200(groupService.getCountGroup(user_id));
    }
}
