package com.bryczek.worker.service.service;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FibonacciRepoDB extends CrudRepository<FibonacciDB, Long> {
}
