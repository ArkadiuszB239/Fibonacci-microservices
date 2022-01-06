package com.bryczek.centralapplication.redis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("Fibonacci")
@AllArgsConstructor
@Data
@TypeAlias("Fibonacci")
public class Fibonacci implements Serializable {
    private Long id;
    private Long value;
}
