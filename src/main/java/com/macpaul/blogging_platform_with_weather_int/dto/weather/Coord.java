package com.macpaul.blogging_platform_with_weather_int.dto.weather;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Coord {
    private Double lon;
    private Double lat;
}
