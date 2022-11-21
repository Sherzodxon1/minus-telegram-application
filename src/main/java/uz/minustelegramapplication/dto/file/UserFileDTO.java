package uz.minustelegramapplication.dto.file;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserFileDTO {

    private Integer id;

    private String name;

    private String originalName;

    private Long size;

    private String mimeType;

    private boolean active;

}
