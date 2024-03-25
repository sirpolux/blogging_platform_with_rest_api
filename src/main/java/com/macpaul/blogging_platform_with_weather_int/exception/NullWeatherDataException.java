package com.macpaul.blogging_platform_with_weather_int.exception;

public class NullWeatherDataException extends RuntimeException {
    public NullWeatherDataException(String msg){
        super(msg);
    }
}
