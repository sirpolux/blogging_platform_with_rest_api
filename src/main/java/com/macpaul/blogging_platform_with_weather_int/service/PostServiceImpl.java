package com.macpaul.blogging_platform_with_weather_int.service;

import com.macpaul.blogging_platform_with_weather_int.dto.post.PostDto;
import com.macpaul.blogging_platform_with_weather_int.dto.post.PostResponseDto;
import com.macpaul.blogging_platform_with_weather_int.exception.InvalidPostArgumentException;
import com.macpaul.blogging_platform_with_weather_int.exception.PostNotFoundException;
import com.macpaul.blogging_platform_with_weather_int.mapper.PostMapper;
import com.macpaul.blogging_platform_with_weather_int.mapper.WeatherMapper;
import com.macpaul.blogging_platform_with_weather_int.model.Post;
import com.macpaul.blogging_platform_with_weather_int.model.WeatherCondition;
import com.macpaul.blogging_platform_with_weather_int.repository.PostRepository;
import com.macpaul.blogging_platform_with_weather_int.repository.WeatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        WeatherCondition weather = weatherService.getWeatherFromApi(postDto);
        weather.setPost(post);
        WeatherCondition weather2=weatherRepository.save(weather);
        post.setWeatherCondition(weather2);
        return postMapper.toPostResponseDto(post);
    }
    @Override
    public PostResponseDto getPost(Integer postId) {
        if (postId==null){
            throw new PostNotFoundException("Error: No Post Id provided");
        }
        Optional<Post> post = postRepository.findById(postId);
        return post.map(postMapper::toPostResponseDto).orElse(null);
    }
    @Override
    public List<PostResponseDto> getAllPost(Integer pageSize, Integer pageNo) {
        if(pageSize ==null || pageNo==null){
            List<Post> postResponseDtos=postRepository.findAll();
            return postResponseDtos.stream().map(postMapper::toPostResponseDto).toList();
        }else{
            Pageable pageable = PageRequest.of(pageNo,pageSize);
            Page<Post> page= postRepository.findAll(pageable);
            return page.stream().map(postMapper::toPostResponseDto).toList();
        }
    }
    @Override
    public PostResponseDto update(PostDto postDto) {
        if (postDto.id()==null){
            throw new InvalidPostArgumentException("Error: Post Id must be provided to perform an update");
        }
        Optional<Post> post = postRepository.findById(postDto.id());
        if (post.isEmpty()){
            throw new PostNotFoundException("Error: Target post not found, failed performing update");
        }
        Post postData = post.get();
        postData.setTitle(postDto.title());
        postData.setContent(postDto.content());
        postData.setAuthor(postDto.author());

        postData.setId(postDto.id());
        Post postData2 = postRepository.save(postData);
        WeatherCondition weather = weatherService.getWeatherFromApi(postDto);

        weather.setPost(postData);
        weather.setId(postData.getWeatherCondition().getId());
        WeatherCondition weather2=weatherRepository.save(weather);
        postData.setWeatherCondition(weather2);
        return postMapper.toPostResponseDto(postData2);
    }

    @Override
    public void delete(Integer postId) {
        Optional<Post> post = postRepository.findById(postId);
        if (post.isEmpty()){
            throw new PostNotFoundException("Error: Target post not found or is already deleted");
        }
        postRepository.delete(post.get());
    }
}
