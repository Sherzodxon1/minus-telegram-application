package uz.minustelegramapplication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uz.minustelegramapplication.dto.group.GroupCreateDTO;
import uz.minustelegramapplication.dto.group.GroupDTO;
import uz.minustelegramapplication.dto.group.GroupUpdateDTO;
import uz.minustelegramapplication.entity.Group;
import uz.minustelegramapplication.mapper.qualifier.GTypeQualifier;

@Mapper(componentModel = "spring",
        uses = {
                UserMapper.class,
                GTypeQualifier.class
        }
)
public interface GroupMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "active", source = "active")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "uuid", source = "uuid")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "link", source = "link")
    @Mapping(target = "groupType", source = "groupType")
    @Mapping(target = "owner", source = "owner")
    GroupDTO toDto(Group group);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "link", ignore = true)
    @Mapping(target = "ownerId", source = "ownerId")
    @Mapping(target = "groupType", source = "groupTypeName", qualifiedByName = "mapGroupType")
    Group toEntity(GroupCreateDTO dto);

    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "groupType", source = "dto.groupTypeName", qualifiedByName = "mapGroupType")
    @Mapping(target = "username", source = "dto.username")
    @Mapping(target = "ownerId", source = "dto.ownerId")
    Group toEntity(@MappingTarget Group group, GroupUpdateDTO dto);

}
