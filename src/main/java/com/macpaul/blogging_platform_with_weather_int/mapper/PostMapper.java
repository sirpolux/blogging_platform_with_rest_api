package com.macpaul.blogging_platform_with_weather_int.mapper;

import com.macpaul.blogging_platform_with_weather_int.dto.post.PostDto;
import com.macpaul.blogging_platform_with_weather_int.model.Post;
import org.springframework.stereotype.Service;

@Service
public class PostMapper {
    public Post toPost(PostDto postDto){
        return Post.builder()
                    .title(postDto.title())
                    .author(postDto.title())
                    .content(postDto.content())
                .build();
    }
}
