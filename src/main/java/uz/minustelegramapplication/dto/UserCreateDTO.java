package uz.minustelegramapplication.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@ToString
public class UserCreateDTO {

    @NotBlank(message = "First name is required !!!")
    private String firstName;

    @NotBlank(message = "Last name is required !!!")
    private String lastName;

    @NotBlank(message = "Phone is required !!!")
    private String phone;

    @NotBlank(message = "User name is required !!!")
    private String userName;

    @NotBlank(message = "Password is required !!!")
    private String password;

    @NotBlank(message = "bio is required !!!")
    private String bio;

}
