package com.macpaul.blogging_platform_with_weather_int.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
public class Post extends AuditBaseEntity {
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;
    @Column(nullable = false)
    private String author;
    @Column(nullable = false)
    private Float temperature;
    @Column(nullable = false)
    private String weatherCondition;


}
