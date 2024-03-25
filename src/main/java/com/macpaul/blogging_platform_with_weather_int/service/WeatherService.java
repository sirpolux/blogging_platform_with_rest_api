package com.macpaul.blogging_platform_with_weather_int.service;

import com.macpaul.blogging_platform_with_weather_int.dto.post.PostDto;
import com.macpaul.blogging_platform_with_weather_int.dto.weather.WeatherDto;
import com.macpaul.blogging_platform_with_weather_int.model.WeatherCondition;

public interface WeatherService {
    WeatherCondition getWeatherFromApi(PostDto postDto);
}
