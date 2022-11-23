package uz.minustelegramapplication.dto.channel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class ChannelUpdateDTO {

    @NotNull(message = "Id is required !!!")
    private Integer id;

    @NotBlank(message = "Name is required !!!")
    private String name;

    @NotBlank(message = "Username is required !!!")
    private String username;

    @NotBlank(message = "Channel type is required !!!")
    private String channelTypeName;

}
