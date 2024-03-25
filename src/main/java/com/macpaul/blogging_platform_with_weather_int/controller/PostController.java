package com.macpaul.blogging_platform_with_weather_int.controller;

import com.macpaul.blogging_platform_with_weather_int.dto.PostDto;
import com.macpaul.blogging_platform_with_weather_int.dto.PostResponseDto;
import com.macpaul.blogging_platform_with_weather_int.dto.ResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {
    @PostMapping
    public PostResponseDto save(@RequestBody PostDto blogDto){
        return null;
    }
    @GetMapping
    public List<PostResponseDto> getAllPost(@RequestParam Integer pageSize, @RequestParam Integer pageNo){
        return null;
    }
    @GetMapping("/{postId}")
    public PostResponseDto getPost(@PathVariable Integer postId){
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

}
