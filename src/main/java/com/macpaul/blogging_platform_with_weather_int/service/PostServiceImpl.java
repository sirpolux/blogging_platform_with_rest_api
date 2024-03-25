package com.macpaul.blogging_platform_with_weather_int.service;

import com.macpaul.blogging_platform_with_weather_int.dto.PostDto;
import com.macpaul.blogging_platform_with_weather_int.dto.PostResponseDto;
import com.macpaul.blogging_platform_with_weather_int.dto.ResponseDto;

import java.util.List;

public class PostServiceImpl implements PostService {
    @Override
    public PostResponseDto save(PostDto postDto) {
        return null;
    }

    @Override
    public List<PostResponseDto> getAllPost(Integer pageSize, Integer pageNo) {
        return null;
    }

    @Override
    public PostResponseDto getPost(Integer postId) {
        return null;
    }

    @Override
    public PostResponseDto update(PostDto postDto) {
        return null;
    }

    @Override
    public ResponseDto delete(Integer postId) {
        return null;
    }
}
