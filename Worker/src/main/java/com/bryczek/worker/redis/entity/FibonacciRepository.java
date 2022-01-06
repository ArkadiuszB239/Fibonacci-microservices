package com.bryczek.worker.redis.entity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FibonacciRepository extends CrudRepository<Fibonacci, Long> {
    @Override
    List<Fibonacci> findAll();
}
