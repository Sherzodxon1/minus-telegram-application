package uz.minustelegramapplication.dto.chatMessage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import uz.minustelegramapplication.dto.UserDTO;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageDTO {

    private Integer id;

    private String text;

    private ChatDTO chat;

    private UUID uuid;

    private UserDTO user;

    private boolean isView;

    private LocalDateTime dataTime = LocalDateTime.now();

}
