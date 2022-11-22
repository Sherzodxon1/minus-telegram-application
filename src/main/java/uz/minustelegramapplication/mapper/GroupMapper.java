package uz.minustelegramapplication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import uz.minustelegramapplication.base.BaseURI;
import uz.minustelegramapplication.dto.group.GroupCreateDTO;
import uz.minustelegramapplication.dto.group.GroupDTO;
import uz.minustelegramapplication.dto.group.GroupUpdateDTO;
import uz.minustelegramapplication.entity.Group;
import uz.minustelegramapplication.mapper.qualifier.GTypeQualifier;

import java.util.UUID;

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
    @Mapping(target = "username", source = "username")
    @Mapping(target = "link", source = "uuid", qualifiedByName = "getLink")
    @Mapping(target = "groupType", source = "groupType")
    @Mapping(target = "owner", source = "owner")
    GroupDTO toDto(Group group);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "ownerId", source = "ownerId")
    @Mapping(target = "groupType", source = "groupTypeName", qualifiedByName = "mapGroupType")
    Group toEntity(GroupCreateDTO dto);

    @Mapping(target = "name",  ignore = true)
    @Mapping(target = "groupType",  ignore = true)
    @Mapping(target = "username", source = "dto.username")
    @Mapping(target = "ownerId", ignore = true)
    Group toEntity(@MappingTarget Group group, GroupUpdateDTO dto);

    @Named("getLink")
    default String getLink(UUID uuid) {
        return BaseURI.TME + uuid.toString();
    }

}
