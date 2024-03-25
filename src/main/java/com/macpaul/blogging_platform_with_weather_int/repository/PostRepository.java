package com.macpaul.blogging_platform_with_weather_int.repository;

import com.macpaul.blogging_platform_with_weather_int.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}
