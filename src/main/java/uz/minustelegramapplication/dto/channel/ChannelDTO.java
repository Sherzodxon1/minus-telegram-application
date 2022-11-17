package uz.minustelegramapplication.dto.channel;

import lombok.*;
import uz.minustelegramapplication.dto.UserDTO;
import uz.minustelegramapplication.enums.ChannelType;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChannelDTO {

    private Integer id;

    private String name;

    private UUID uuid;

    private String username;

    private String link;

    private ChannelType channelType;

    private UserDTO owner;

    private boolean active;
}
