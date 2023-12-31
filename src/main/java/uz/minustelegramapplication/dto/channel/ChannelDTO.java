package uz.minustelegramapplication.dto.channel;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.minustelegramapplication.dto.UserDTO;
import uz.minustelegramapplication.enums.ChannelType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChannelDTO {

    private Integer id;

    private String name;

    private String username;

    private String link;

    private ChannelType channelType;

    private UserDTO owner;

    private boolean active;

}
