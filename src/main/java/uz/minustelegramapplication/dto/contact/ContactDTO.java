package uz.minustelegramapplication.dto.contact;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContactDTO {

    private Integer id;

    private String firstName;

    private String lastName;

    private Integer phone;

    private boolean active;

    private UUID uuid;
}
