package com.macpaul.blogging_platform_with_weather_int.dto.weather;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Weather {
    private Integer id;
    private String main;
    private  String description;
    private String icon;
}
