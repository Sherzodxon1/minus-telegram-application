package uz.minustelegramapplication.dto.channel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class ChannelCreateDTO {

    @NotBlank(message = "Name is required !!!")
    private String name;

    @NotNull(message = "User id is required !!!")
    private Integer ownerId;

    @NotBlank(message = "Channel type is required !!!")
    private String channelTypeName;

}
