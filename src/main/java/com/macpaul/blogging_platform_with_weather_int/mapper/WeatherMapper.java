package com.macpaul.blogging_platform_with_weather_int.mapper;


import com.macpaul.blogging_platform_with_weather_int.dto.weather.WeatherDto;
import com.macpaul.blogging_platform_with_weather_int.model.WeatherCondition;
import org.springframework.stereotype.Service;

@Service
public class WeatherMapper {
    public WeatherCondition toWeatherCondition(WeatherDto weatherDto){
        return  WeatherCondition.builder()
                .temperature(weatherDto.getMain().getTemp())
                .weatherCondition(weatherDto.getWeather().get(0).getDescription())
                .name(weatherDto.getName())
                .timeZone(weatherDto.getTimezone())
                .build();
    }
}
