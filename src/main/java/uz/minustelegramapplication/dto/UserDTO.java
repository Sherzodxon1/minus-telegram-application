package uz.minustelegramapplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private Integer id;

    private String firstName;

    private String lastName;

    private Integer phone;

    private String userName;

    private boolean active;

    private String bio;

    private UUID uuid;
}
