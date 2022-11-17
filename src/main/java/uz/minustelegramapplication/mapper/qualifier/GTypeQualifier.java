package uz.minustelegramapplication.mapper.qualifier;

import org.mapstruct.Mapper;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;
import uz.minustelegramapplication.enums.GroupType;

@Component
@Mapper
public class GTypeQualifier {

    @Named("mapGroupType")
    public GroupType mapGroupType(String groupTypeName) {
        return GroupType.getByName(groupTypeName);
    }
}
