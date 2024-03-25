package com.macpaul.blogging_platform_with_weather_int.service;

import com.macpaul.blogging_platform_with_weather_int.dto.post.PostDto;
import com.macpaul.blogging_platform_with_weather_int.dto.post.PostResponseDto;
import com.macpaul.blogging_platform_with_weather_int.dto.ResponseDto;
import com.macpaul.blogging_platform_with_weather_int.mapper.PostMapper;
import com.macpaul.blogging_platform_with_weather_int.model.Post;
import com.macpaul.blogging_platform_with_weather_int.model.WeatherCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;
    @Override
    public PostResponseDto save(PostDto postDto) {
        Post post = postMapper.toPost(postDto);
        Double lat = postDto.latitude()==null?6.5244:postDto.latitude();
        Double lon = postDto.longitude()==null?3.3792: postDto.longitude();

        WeatherCondition weather = new WeatherCondition();

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
