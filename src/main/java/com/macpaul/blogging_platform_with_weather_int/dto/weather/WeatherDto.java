package com.macpaul.blogging_platform_with_weather_int.dto.weather;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDto {
    private Coord coord;
    private List<Weather> weather;
    private String base;
    private Main main;
    private Integer visibility;
    private Wind wind;
    private Clouds clouds;
    private Long dt;
    private Sys sys;
    private Integer timezone;
    private Integer id;
    private String name;
    private Integer cod;
}
