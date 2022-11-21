package uz.minustelegramapplication.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import uz.minustelegramapplication.dto.contact.ContactCreateDTO;
import uz.minustelegramapplication.dto.contact.ContactDTO;
import uz.minustelegramapplication.dto.contact.ContactUpdateDTO;
import uz.minustelegramapplication.entity.Contact;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    @Mapping(target = "id", source = "id")
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "uuid", source = "uuid")
    ContactDTO toDto(Contact contact);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "firstName", source = "firstName")
    @Mapping(target = "lastName", source = "lastName")
    @Mapping(target = "phone", source = "phone")
    @Mapping(target = "uuid", ignore = true)
    @Mapping(target = "active", ignore = true)
    Contact toEntity(ContactCreateDTO dto);

    @Mapping(target = "firstName", source = "dto.firstName")
    @Mapping(target = "lastName", source = "dto.lastName")
    @Mapping(target = "phone", source = "dto.phone")
    Contact toEntity(@MappingTarget Contact contact, ContactUpdateDTO dto);
}
