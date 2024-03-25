package com.macpaul.blogging_platform_with_weather_int.controller;

import com.macpaul.blogging_platform_with_weather_int.dto.post.PostDto;
import com.macpaul.blogging_platform_with_weather_int.dto.post.PostResponseDto;
import com.macpaul.blogging_platform_with_weather_int.dto.ResponseDto;
import com.macpaul.blogging_platform_with_weather_int.dto.weather.WeatherDto;
import com.macpaul.blogging_platform_with_weather_int.service.PostService;
import com.macpaul.blogging_platform_with_weather_int.service.WeatherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final WeatherService weatherService;

    private final PostService postService;
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public PostResponseDto save(@Valid @RequestBody PostDto postDto){
        return postService.save(postDto);
    }
    @GetMapping("/{postId}")
    public PostResponseDto getPost(@PathVariable Integer postId){
        return null;
    }
    @GetMapping
    public List<PostResponseDto> getAllPost(@RequestParam Integer pageSize, @RequestParam Integer pageNo){
        return null;
    }

    @PutMapping
    public PostResponseDto updatePost(@RequestBody PostDto postDto){
        return null;
    }
    @DeleteMapping
    public ResponseDto deletePost(@PathVariable Integer postId){
        return null;
    }

//    @GetMapping("/test")
//    public WeatherDto test(){
//
//        return weatherService.getWeather(6.5244,3.3792);
//    }

}
