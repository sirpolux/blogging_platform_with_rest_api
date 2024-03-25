package com.macpaul.blogging_platform_with_weather_int.service;

import com.macpaul.blogging_platform_with_weather_int.dto.WeatherDto;

public interface WeatherService {
    WeatherDto getWeather(Double lat, Double lon);
}
