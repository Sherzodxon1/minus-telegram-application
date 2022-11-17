package uz.minustelegramapplication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import uz.minustelegramapplication.dto.chatMessage.ChatMessageDTO;
import uz.minustelegramapplication.entity.ChatMessage;

@Mapper(componentModel = "spring")
public interface ChatMessageMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "text", source = "text")
    @Mapping(target = "chat", source = "chat")
    @Mapping(target = "uuid", source = "uuid")
    @Mapping(target = "user", source = "sender")
    @Mapping(target = "dataTime", source = "dataTime")

    ChatMessageDTO toDto(ChatMessage chatMessage);
}
