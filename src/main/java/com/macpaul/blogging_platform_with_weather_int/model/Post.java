package com.macpaul.blogging_platform_with_weather_int.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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

    @OneToOne(mappedBy = "post",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false)
    @JsonManagedReference
    private WeatherCondition weatherCondition;

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", weatherCondition=" + weatherCondition +
                '}';
    }
}
