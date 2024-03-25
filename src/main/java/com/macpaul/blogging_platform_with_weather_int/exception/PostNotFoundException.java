package com.macpaul.blogging_platform_with_weather_int.exception;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(String msg){
        super(msg);
    }
}
