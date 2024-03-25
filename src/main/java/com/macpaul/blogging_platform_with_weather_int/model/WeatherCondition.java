package com.macpaul.blogging_platform_with_weather_int.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class WeatherCondition extends BaseEntity{
    private Double temperature;
    private String weatherCondition;
    private Integer timeZone;
    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id", unique = true)
    @JsonBackReference
    private Post post;

    @Override
    public String ddtoString() {
        return "WeatherCondition{" +
                "temperature=" + temperature +
                ", weatherCondition='" + weatherCondition + '\'' +
                ", timeZone=" + timeZone +
                ", name='" + name + '\'' +
                ", post=" + post +
                '}';
    }
}
