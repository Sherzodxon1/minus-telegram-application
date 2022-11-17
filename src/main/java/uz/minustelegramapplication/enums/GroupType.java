package uz.minustelegramapplication.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GroupType {

    GROUP("group"),
    SUPERGROUP("supergroup");

    private final String name;

}
