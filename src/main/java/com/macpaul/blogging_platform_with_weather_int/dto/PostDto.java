package com.macpaul.blogging_platform_with_weather_int.dto;

public record PostDto(
    String title,
    String content,
    String author,
    float longitude,
    float latitude
) {
}
