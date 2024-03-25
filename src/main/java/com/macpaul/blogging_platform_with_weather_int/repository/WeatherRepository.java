package com.macpaul.blogging_platform_with_weather_int.repository;

import com.macpaul.blogging_platform_with_weather_int.model.Weather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherRepository extends JpaRepository<Weather, Integer> {
}
