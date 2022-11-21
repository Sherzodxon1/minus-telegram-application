package uz.minustelegramapplication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.minustelegramapplication.dto.file.UserFileDTO;
import uz.minustelegramapplication.entity.UserFile;

@Mapper(componentModel = "spring")
public interface UserFileMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "active", source = "active")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "originalName", source = "originalName")
    @Mapping(target = "size", source = "size")
    @Mapping(target = "mimeType", source = "mimeType")
    UserFileDTO toDto(UserFile file);
}
