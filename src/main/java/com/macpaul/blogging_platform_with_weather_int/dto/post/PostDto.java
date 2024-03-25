package com.macpaul.blogging_platform_with_weather_int.dto.post;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public record PostDto(
        @NotEmpty(message="No Title: Please provide a title")
        @Size(min = 5, message = "Title too short: Must have up to 5 characters")
        @Size(max =100, message = "Title too long: Must have 100 or less characters")
        String title,
        @NotEmpty(message="No content: Please provide post content")
        @Size(min = 5, message = "Content too short: Must have up to 15 characters")
        @Size(max =2000, message = "Content too long: Must have 2000 or less characters")
        String content,
        @NotEmpty(message="No Author: Please provide Author name")
        @Size(min = 5, message = "Author too short: Must have up to 5 characters")
        @Size(max =50, message = "Author too long: Must have 100 or less characters")
        String author,
        Double longitude,
        Double latitude
) {
}
