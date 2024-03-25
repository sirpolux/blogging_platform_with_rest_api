package com.macpaul.blogging_platform_with_weather_int.service;

import com.macpaul.blogging_platform_with_weather_int.dto.post.PostDto;
import com.macpaul.blogging_platform_with_weather_int.dto.post.PostResponseDto;
import com.macpaul.blogging_platform_with_weather_int.dto.ResponseDto;
import com.macpaul.blogging_platform_with_weather_int.dto.weather.WeatherDto;
import com.macpaul.blogging_platform_with_weather_int.mapper.PostMapper;
import com.macpaul.blogging_platform_with_weather_int.mapper.WeatherMapper;
import com.macpaul.blogging_platform_with_weather_int.model.Post;
import com.macpaul.blogging_platform_with_weather_int.model.WeatherCondition;
import com.macpaul.blogging_platform_with_weather_int.repository.PostRepository;
import com.macpaul.blogging_platform_with_weather_int.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostMapper postMapper;
    private final WeatherMapper weatherMapper;
    private final WeatherService weatherService;
    private final PostRepository postRepository;
    private final WeatherRepository weatherRepository;

    @Override
    public PostResponseDto save(PostDto postDto) {
        Post post = postRepository.save(postMapper.toPost(postDto));
        Double lat = postDto.latitude()==null?6.5244:postDto.latitude();
        Double lon = postDto.longitude()==null?3.3792:postDto.longitude();
        WeatherDto weatherDto = weatherService.getWeatherFromApi(lat,lon);
        WeatherCondition weather = weatherMapper.toWeatherCondition(weatherDto);
        weather.setPost(post);
        WeatherCondition weather2=weatherRepository.save(weather);
        post.setWeatherCondition(weather2);
        return postMapper.toPostResponseDto(post);
    }
    @Override
    public PostResponseDto getPost(Integer postId) {
        Optional<Post> post = postRepository.findById(postId);
        System.out.println(post.get());
        return null;
    }
    @Override
    public List<PostResponseDto> getAllPost(Integer pageSize, Integer pageNo) {
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
