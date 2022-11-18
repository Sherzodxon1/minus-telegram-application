package uz.minustelegramapplication.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum GroupType {

    PRIVATE("private"),
    PUBLIC("public"),
    GROUP("group"),
    SUPERGROUP("supergroup"),
    UNKNOWN("unknown");

    private final String name;

    public static GroupType getByName(final String name) {
        return Arrays.stream(GroupType.values())
                .filter(group -> group.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(UNKNOWN);
    }

}
