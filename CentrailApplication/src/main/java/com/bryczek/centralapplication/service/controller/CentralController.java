package com.bryczek.centralapplication.service.controller;

import com.bryczek.centralapplication.redis.entity.Fibonacci;
import com.bryczek.centralapplication.redis.entity.FibonacciRepository;
import com.bryczek.centralapplication.service.model.FibonacciDTO;
import com.bryczek.centralapplication.service.service.FiboDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CentralController {

    private final FibonacciRepository fibonacciRepository;
    private final FiboDbService fiboDbService;

    @PostMapping("/fibo/calc")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<HttpStatus> calculateFibonacci(@RequestBody FibonacciDTO fibo) {
        if (!fiboDbService.checkIfExists(fibo.getValue())) {
            if (fibonacciRepository.findByValue(fibo.getValue()) == null){
                Fibonacci fibonacci = new Fibonacci(fibo.getValue(), fibo.getValue());
                fibonacciRepository.save(fibonacci);
                return ResponseEntity.ok(HttpStatus.OK);
            }
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @GetMapping("/fibo/getValues")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<FibonacciDTO>> getCalculatedFibonacci() {
        return ResponseEntity.ok(fiboDbService.getValues());
    }

}
