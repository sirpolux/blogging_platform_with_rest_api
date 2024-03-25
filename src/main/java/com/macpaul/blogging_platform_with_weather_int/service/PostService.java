package com.macpaul.blogging_platform_with_weather_int.service;

import com.macpaul.blogging_platform_with_weather_int.dto.post.PostDto;
import com.macpaul.blogging_platform_with_weather_int.dto.post.PostResponseDto;
import com.macpaul.blogging_platform_with_weather_int.dto.ResponseDto;

import java.util.List;

public interface PostService {
    PostResponseDto save(PostDto postDto);
    List<PostResponseDto> getAllPost(Integer pageSize, Integer pageNo);
    PostResponseDto getPost(Integer postId);
    PostResponseDto update(PostDto postDto);
    void delete(Integer postId);

}
