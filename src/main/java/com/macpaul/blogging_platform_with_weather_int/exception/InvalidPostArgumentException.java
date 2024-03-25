package com.macpaul.blogging_platform_with_weather_int.exception;

public class InvalidPostArgumentException extends RuntimeException{
    public InvalidPostArgumentException(String msg){
        super(msg);
    }
}
