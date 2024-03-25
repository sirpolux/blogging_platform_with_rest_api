package com.macpaul.blogging_platform_with_weather_int.service;

import com.macpaul.blogging_platform_with_weather_int.dto.weather.WeatherDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class WeatherServiceImpl implements WeatherService {

    @Value("${weather.api.key}")
    private String apiKey;
    @Override
    public WeatherDto getWeather(Double lat, Double lon) {
        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + apiKey;
        RestTemplate restTemplate =new RestTemplate();
        WeatherDto weather =restTemplate.getForObject(apiUrl, WeatherDto.class);
        return weather;
    }
}
