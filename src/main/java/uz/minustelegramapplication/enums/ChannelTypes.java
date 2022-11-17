package uz.minustelegramapplication.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ChannelTypes {

    PRIVATE("private"),
    PUBLIC("public");

    private final String name;
}
