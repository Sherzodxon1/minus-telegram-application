package uz.minustelegramapplication.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum ChannelType {

    PRIVATE("private"),
    PUBLIC("public"),
    UNKNOWN("unknown");

    private final String name;

    public static ChannelType getByName(final String name) {
        return Arrays.stream(ChannelType.values())
                .filter(channel -> channel.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(UNKNOWN);
    }
}
