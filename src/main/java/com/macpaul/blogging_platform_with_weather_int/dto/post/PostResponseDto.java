package com.macpaul.blogging_platform_with_weather_int.dto.post;

public record PostResponseDto(
        Integer id,
        String title,
        String content,
        String author,
        Double temperature,
        String weather_condition,
        String location,
        Integer timezone
) {
}
