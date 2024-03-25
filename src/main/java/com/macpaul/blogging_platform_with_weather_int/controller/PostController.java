package com.macpaul.blogging_platform_with_weather_int.controller;

import com.macpaul.blogging_platform_with_weather_int.dto.ResponseDto;
import com.macpaul.blogging_platform_with_weather_int.dto.post.PostDto;
import com.macpaul.blogging_platform_with_weather_int.dto.post.PostResponseDto;
import com.macpaul.blogging_platform_with_weather_int.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;
    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public PostResponseDto save(@Valid @RequestBody PostDto postDto){
        return postService.save(postDto);
    }
    @GetMapping("/{postId}")
    @ResponseStatus(HttpStatus.OK)
    public PostResponseDto getPost(@PathVariable Integer postId){
        return postService.getPost(postId);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PostResponseDto> getAllPost(@RequestParam Integer pageSize, @RequestParam Integer pageNo){
        return null;
    }

    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public PostResponseDto updatePost(@RequestBody PostDto postDto){
        return null;
    }
    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void  deletePost(@PathVariable Integer postId){

    }



}
