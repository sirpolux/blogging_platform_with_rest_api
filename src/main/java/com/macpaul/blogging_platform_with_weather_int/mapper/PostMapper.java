package com.macpaul.blogging_platform_with_weather_int.mapper;

import com.macpaul.blogging_platform_with_weather_int.dto.post.PostDto;
import com.macpaul.blogging_platform_with_weather_int.dto.post.PostResponseDto;
import com.macpaul.blogging_platform_with_weather_int.model.Post;
import org.springframework.stereotype.Service;

@Service
public class PostMapper {
    public Post toPost(PostDto postDto){
        return Post.builder()
                    .title(postDto.title())
                    .author(postDto.author())
                    .content(postDto.content())
                .build();
    }
    public PostResponseDto toPostResponseDto(Post post){
        return new PostResponseDto(post.getId(), post.getTitle(),
                post.getContent(), post.getContent(), post.getWeatherCondition().getTemperature(),
                post.getWeatherCondition().getWeatherCondition(), post.getWeatherCondition().getName(),
                post.getWeatherCondition().getTimeZone());
    }
}
