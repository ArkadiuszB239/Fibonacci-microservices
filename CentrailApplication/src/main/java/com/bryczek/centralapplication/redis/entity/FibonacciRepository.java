package com.bryczek.centralapplication.redis.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FibonacciRepository extends CrudRepository<Fibonacci, Long> {
    Fibonacci findByValue(Long value);
}
