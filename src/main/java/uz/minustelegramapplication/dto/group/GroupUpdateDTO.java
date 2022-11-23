package uz.minustelegramapplication.dto.group;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class GroupUpdateDTO {

    @NotNull(message = "Id is required !!!")
    private Integer id;

    @NotBlank(message = "Name is required !!!")
    private String name;

    @NotBlank(message = "Username is required !!!")
    private String username;

    @NotBlank(message = "Group type is required !!!")
    private String groupTypeName;

}
