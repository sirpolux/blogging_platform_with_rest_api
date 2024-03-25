package com.macpaul.blogging_platform_with_weather_int.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class WeatherCondition extends BaseEntity{
    private String temperature;
    private String weatherCondition;
}
