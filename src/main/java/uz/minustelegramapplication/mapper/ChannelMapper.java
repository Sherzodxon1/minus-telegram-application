package uz.minustelegramapplication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uz.minustelegramapplication.dto.channel.ChannelCreateDTO;
import uz.minustelegramapplication.dto.channel.ChannelDTO;
import uz.minustelegramapplication.dto.channel.ChannelUpdateDTO;
import uz.minustelegramapplication.entity.Channel;
import uz.minustelegramapplication.mapper.qualifier.ChTypeQualifier;

@Mapper(componentModel = "spring",
        uses = ChTypeQualifier.class)
public interface ChannelMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "active", source = "active")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "uuid", source = "uuid")
    @Mapping(target = "channelType", source = "channelType")
    @Mapping(target = "user", source = "owner")
    ChannelDTO toDto(Channel channel);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "active", ignore = true)
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "name", source = "name")
    @Mapping(target = "ownerId", source = "ownerId")
    @Mapping(target = "channelType", source = "channelTypeName", qualifiedByName = "mapChannelType")
    Channel toEntity(ChannelCreateDTO dto);

    @Mapping(target = "name", source = "dto.name")
    @Mapping(target = "channelType", source = "dto.channelTypeName", qualifiedByName = "mapChannelType")
    @Mapping(target = "ownerId", source = "dto.ownerId")
    Channel toEntity(@MappingTarget Channel channel, ChannelUpdateDTO dto);

}
