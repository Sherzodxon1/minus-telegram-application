package uz.minustelegramapplication.dto.contact;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString

public class ContactUpdateDTO {

    @NotNull(message = "Id is required!!!")
    private Integer id;

    @NotBlank(message = "First name is required !!!")
    private String firstName;

    @NotBlank(message = "Last name is required !!!")
    private String lastName;

    @NotBlank(message = "Phone is required !!!")
    private String phone;

}
