package uz.minustelegramapplication.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import uz.minustelegramapplication.dto.file.UserFileDTO;
import uz.minustelegramapplication.entity.User;
import uz.minustelegramapplication.entity.UserFile;
import uz.minustelegramapplication.helper.Utils;
import uz.minustelegramapplication.mapper.UserFileMapper;
import uz.minustelegramapplication.repo.UserFileRepo;
import uz.minustelegramapplication.repo.UserRepository;
import uz.minustelegramapplication.response.ResponseData;
import uz.minustelegramapplication.service.FileService;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final UserFileRepo repo;
    private final UserFileMapper mapper;
    private final UserRepository userRepository;

    private final Path root = Paths.get("D:\\Spring\\UserFiles");

    @Override
    public ResponseEntity<ResponseData<List<UserFileDTO>>> getAllByUser(Integer userId) {

        Optional<User> user = userRepository.findById(userId);

        if (user.isEmpty()) {
            return ResponseData.notFoundData("User is not found !!!");
        } else if (!user.get().isActive()) {
            return ResponseData.inActive("This User's status is inactive !!!");
        }

        List<UserFile> list = repo.findAllByUserId(userId);

        if (Utils.isEmpty(list)) {
            return ResponseData.notFoundData("Files are not found !!!");
        }

        List<UserFileDTO> responseList = new ArrayList<>();
        for (UserFile file : list) {
            UserFileDTO dto = mapper.toDto(file);
            responseList.add(dto);
        }
        return ResponseData.success200(responseList);
    }

    @Override
    public ResponseEntity<ResponseData<UserFileDTO>> upload(MultipartFile file) {
        final String fileOriginalName = file.getOriginalFilename();
        if (!StringUtils.hasText(fileOriginalName)) {
            return ResponseData.notFoundData("File name should be null !!!");
        }

        String format = fileOriginalName.split("\\.")[1];

        final String fileName = UUID.randomUUID().toString() + "." + format;

        try {
            Files.copy(file.getInputStream(), root.resolve(fileName), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }

        UserFile userFile = new UserFile();
        userFile.setName(fileName);
        userFile.setOriginalName(fileOriginalName);
        userFile.setSize(file.getSize());
        userFile.setMimeType(file.getContentType());
//        userFile.setUserId(???????????);
        repo.save(userFile);

        return ResponseData.success201(mapper.toDto(userFile));
    }

    @Override
    public void download(String name, HttpServletResponse response) {
        Optional<UserFile> userFile = repo.findByName(name);
        if (userFile.isEmpty()) {
            throw new RuntimeException("File is not found !!!");
        }

        UserFile file = userFile.get();

        response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getOriginalName() + "\"");
        response.setContentType(file.getMimeType());

        Path filePath = root.resolve(name).normalize();

        try {
            FileCopyUtils.copy(new FileInputStream(filePath.toString()), response.getOutputStream());
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void attachUser(List<Integer> ids, Integer userId) {
        List<UserFile> files = new ArrayList<>();
        for (Integer id : ids) {
            Optional<UserFile> userFile = repo.findById(id);
            if (userFile.isPresent()) {
                UserFile file = userFile.get();
                file.setUserId(userId);
                files.add(file);
            }
        }
        if (Utils.isPresent(files)) {
            repo.saveAll(files);
        }
    }

}
