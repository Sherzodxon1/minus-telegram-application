package uz.minustelegramapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uz.minustelegramapplication.base.BaseURI;
import uz.minustelegramapplication.dto.file.UserFileDTO;
import uz.minustelegramapplication.response.ResponseData;
import uz.minustelegramapplication.service.FileService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(BaseURI.API + BaseURI.V1 + BaseURI.FILE)
public class FileController {

    private final FileService service;

    @GetMapping(BaseURI.GET + BaseURI.ALL + "/{userId}")
    public ResponseEntity<ResponseData<List<UserFileDTO>>> gelAllByUser(@PathVariable(value = "userId") Integer userId) {
        return service.getAllByUser(userId);
    }

    @PostMapping(BaseURI.UPLOAD)
    public ResponseEntity<ResponseData<UserFileDTO>> upload(@RequestParam(value = "file") MultipartFile file) {
        return service.upload(file);
    }

    @GetMapping(BaseURI.DOWNLOAD + "/{filename:.+}")
    public void download(@PathVariable(name = "filename") String name, HttpServletResponse response) {
        service.download(name, response);
    }

}
