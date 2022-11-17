package uz.minustelegramapplication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.minustelegramapplication.dto.UserDTO;
import uz.minustelegramapplication.entity.User;

@Mapper(componentModel = "spring")
public interface ChatMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "uuid", source = "uuid")
    @Mapping(target = "active", source = "active")
    UserDTO toDto(User user);
}
