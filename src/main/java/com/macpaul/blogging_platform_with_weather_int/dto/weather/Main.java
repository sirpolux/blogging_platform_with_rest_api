package com.macpaul.blogging_platform_with_weather_int.dto.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Main {
    private Double temp;
    private Double feels_like;
    private Double temp_min;
    private Double temp_max;
    private Double pressure;
    private Double humidity;
}
