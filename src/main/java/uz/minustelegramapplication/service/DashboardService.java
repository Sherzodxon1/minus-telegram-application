package uz.minustelegramapplication.service;

import org.springframework.http.ResponseEntity;
import uz.minustelegramapplication.response.ResponseData;

public interface DashboardService {
    ResponseEntity<ResponseData<Integer>> getChannel(Integer id);

    ResponseEntity<ResponseData<Integer>> getGroup(Integer id);
}
