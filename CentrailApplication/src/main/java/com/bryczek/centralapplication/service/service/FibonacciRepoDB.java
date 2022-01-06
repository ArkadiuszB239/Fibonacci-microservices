package com.bryczek.centralapplication.service.service;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FibonacciRepoDB extends CrudRepository<FibonacciDB, Long> {
    Optional<FibonacciDB> findByKeyV(Long key);
}
