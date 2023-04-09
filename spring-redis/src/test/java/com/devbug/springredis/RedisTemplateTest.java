package com.devbug.springredis;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
public class RedisTemplateTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    private static final String REDIS_KEY = "key";

    @BeforeEach
    void setUp() {
        redisTemplate.opsForValue().set(REDIS_KEY, "object");
    }

    @Test
    void getRedisValue() {
        final Object o = redisTemplate.opsForValue().get(REDIS_KEY);

        assertThat(o.toString()).isEqualTo("object");
    }

}
