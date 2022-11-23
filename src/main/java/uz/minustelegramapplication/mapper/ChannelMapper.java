package uz.minustelegramapplication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Named;
import uz.minustelegramapplication.base.BaseURI;
import uz.minustelegramapplication.dto.channel.ChannelCreateDTO;
import uz.minustelegramapplication.dto.channel.ChannelDTO;
import uz.minustelegramapplication.dto.channel.ChannelDeleteDTO;
import uz.minustelegramapplication.dto.channel.ChannelUpdateDTO;
import uz.minustelegramapplication.entity.Channel;
import uz.minustelegramapplication.mapper.qualifier.ChTypeQualifier;

import java.util.UUID;

@Mapper(componentModel = "spring",
        uses = {
                UserMapper.class,
                ChTypeQualifier.class
        }
)
public interface ChannelMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "active", source = "active")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "link", source = "uuid", qualifiedByName = "getLink")
    @Mapping(target = "channelType", source = "channelType")
    @Mapping(target = "owner", source = "owner")
    ChannelDTO toDto(Channel channel);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "ownerId", source = "ownerId")
    @Mapping(target = "channelType", source = "channelTypeName", qualifiedByName = "mapChannelType")
    Channel toEntity(ChannelCreateDTO dto);

    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "channelType", source = "dto.channelTypeName", qualifiedByName = "mapChannelType")
    @Mapping(target = "username", source = "dto.username")
    @Mapping(target = "ownerId", ignore = true)
    Channel toEntity(@MappingTarget Channel channel, ChannelUpdateDTO dto);

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "channelType", ignore = true)
    @Mapping(target = "username", source = "dto.username")
    @Mapping(target = "ownerId", ignore = true)
    Channel toEntity(@MappingTarget Channel channel, ChannelDeleteDTO dto);

    @Named("getLink")
    default String getLink(UUID uuid) {
        return BaseURI.TME + uuid.toString();
    }

}
