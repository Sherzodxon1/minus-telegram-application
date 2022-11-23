package uz.minustelegramapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import uz.minustelegramapplication.base.BaseURI;
import uz.minustelegramapplication.response.ResponseData;
import uz.minustelegramapplication.service.DashboardService;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API + BaseURI.V1 + BaseURI.DASHBOARD)
public class DashboardController {
    private final DashboardService service;

    @GetMapping(BaseURI.CHANNEL)
    public ResponseEntity<ResponseData<Integer>> getCountChannel(@RequestParam(value = "id") Integer id) {
        return service.getChannel(id);
    }

    @GetMapping(BaseURI.GROUP)
    public ResponseEntity<ResponseData<Integer>> getCountGroup(@RequestParam(value = "id") Integer id) {
        return service.getGroup(id);
    }
}
