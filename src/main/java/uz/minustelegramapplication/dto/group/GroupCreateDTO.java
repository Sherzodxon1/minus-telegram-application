package uz.minustelegramapplication.dto.group;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class GroupCreateDTO {

    @NotBlank(message = "Name is required !!!")
    private String name;

    @NotBlank(message = "Username is required !!!")
    private String username;

    @NotNull(message = "User id is required !!!")
    private Integer ownerId;

    @NotBlank(message = "Group type is required !!!")
    private String groupTypeName;

}
