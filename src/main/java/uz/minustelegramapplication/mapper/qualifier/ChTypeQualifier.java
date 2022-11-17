package uz.minustelegramapplication.mapper.qualifier;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import uz.minustelegramapplication.enums.ChannelType;

@Component
@Mapper
public class ChTypeQualifier {

    @Named("mapChannelType")
    public ChannelType mapChannelType(String channelTypeName) {
        return ChannelType.getByName(channelTypeName);
    }
}
