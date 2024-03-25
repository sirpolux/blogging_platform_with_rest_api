package com.macpaul.blogging_platform_with_weather_int.dto.post;

public record PostDto(
    String title,
    String content,
    String author,
    Double longitude,
    Double latitude
) {
}
