package com.macpaul.blogging_platform_with_weather_int.service;

import com.macpaul.blogging_platform_with_weather_int.dto.post.PostDto;
import com.macpaul.blogging_platform_with_weather_int.dto.weather.WeatherDto;
import com.macpaul.blogging_platform_with_weather_int.exception.NullWeatherDataException;
import com.macpaul.blogging_platform_with_weather_int.mapper.WeatherMapper;
import com.macpaul.blogging_platform_with_weather_int.model.WeatherCondition;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class WeatherServiceImpl implements WeatherService {

    private final WeatherMapper weatherMapper;


    @Value("${weather.api.key}")
    private String apiKey;
    @Override
    public WeatherCondition getWeatherFromApi(PostDto postDto) {
        Double lat = postDto.latitude()==null?6.5244:postDto.latitude();
        Double lon = postDto.longitude()==null?3.3792:postDto.longitude();
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey;
        RestTemplate restTemplate =new RestTemplate();
        WeatherDto weather =restTemplate.getForObject(apiUrl, WeatherDto.class);
        if (weather == null) {
            throw new NullWeatherDataException("Weather object is null");
        }
        return weatherMapper.toWeatherCondition(weather);

    }

}
