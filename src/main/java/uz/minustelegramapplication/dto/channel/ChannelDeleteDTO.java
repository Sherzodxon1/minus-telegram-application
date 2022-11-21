package uz.minustelegramapplication.dto.channel;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class ChannelDeleteDTO {

    @NotNull(message = "Id is required !!!")
    private Integer id;

    @NotBlank(message = "Username is required !!!")
    private String username;

}
