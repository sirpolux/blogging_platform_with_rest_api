package com.macpaul.blogging_platform_with_weather_int.dto.weather;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Wind {
    private Double speed;
    private Double deg;
    private Double gust;
}
