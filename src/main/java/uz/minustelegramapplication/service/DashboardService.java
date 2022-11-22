package uz.minustelegramapplication.service;

import org.springframework.http.ResponseEntity;
import uz.minustelegramapplication.response.ResponseData;

public interface DashboardService {
    ResponseEntity<ResponseData<Integer>> getCount(Integer userId);

    ResponseEntity<ResponseData<Integer>> getGroup(Integer user_id);
}
