package uz.minustelegramapplication.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import uz.minustelegramapplication.dto.file.UserFileDTO;
import uz.minustelegramapplication.response.ResponseData;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface FileService {
    ResponseEntity<ResponseData<List<UserFileDTO>>> getAllByUser(Integer userId);

    ResponseEntity<ResponseData<UserFileDTO>> upload(MultipartFile file);

    void download(String name, HttpServletResponse response);

    void attachUser(List<Integer> ids, Integer productId);
}
