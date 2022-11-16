package uz.minustelegramapplication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uz.minustelegramapplication.dto.UserCreateDTO;
import uz.minustelegramapplication.dto.UserDTO;
import uz.minustelegramapplication.dto.UserUpdateDTO;
import uz.minustelegramapplication.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "uuid", source = "uuid")
    @Mapping(target = "bio", source = "bio")
    UserDTO toDto(User user);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "bio", source = "bio")
    @Mapping(target = "active",ignore = true)
    User toEntity(UserCreateDTO dto);

    @Mapping(target = "firstName", source = "dto.firstName")
    @Mapping(target = "lastName", source = "dto.lastName")
    @Mapping(target = "phone", source = "dto.phone")
    @Mapping(target = "password", source = "dto.password")

    User toEntity(@MappingTarget User user, UserUpdateDTO dto);

}
