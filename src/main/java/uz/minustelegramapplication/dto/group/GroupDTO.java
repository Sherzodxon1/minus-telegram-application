package uz.minustelegramapplication.dto.group;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.minustelegramapplication.dto.UserDTO;
import uz.minustelegramapplication.enums.GroupType;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GroupDTO {

    private Integer id;

    private String name;

    private UUID uuid;

    private String username;

    private String link;

    private GroupType groupType;

    private UserDTO owner;

    private boolean active;

}
