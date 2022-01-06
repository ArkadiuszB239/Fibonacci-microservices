package com.bryczek.worker.service.service;


import com.bryczek.worker.redis.entity.Fibonacci;
import com.bryczek.worker.redis.entity.FibonacciRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RefreshScope
@RequiredArgsConstructor
@Slf4j
public class ProcessingCore implements ApplicationListener<RefreshScopeRefreshedEvent> {

    private final FibonacciRepository fibonacciRepository;
    private final FibonacciRepoDB fibonacciRepoDB;


    @Scheduled(cron = "${scheduled.cron}")
    public void processFiboValues() {
        List<Fibonacci> fiboList = new ArrayList<>(fibonacciRepository.findAll());

        log.info("Processing {} records", fiboList.size());

        fiboList.forEach(v -> {
            FibonacciDB fiboDb = FibonacciDB.builder()
                    .keyV(v.getValue())
                    .value(fib(v.getValue()))
                    .build();
            fibonacciRepoDB.save(fiboDb);
            fibonacciRepository.delete(v);
            log.info("Processing calculation for value {}", v.getValue());
        });
        log.info("Processing finished!");
    }


    private Long fib(Long n)
    {
        if (n <= 1)
            return n;
        return fib(n-1) + fib(n-2);
    }

    @Override
    public void onApplicationEvent(RefreshScopeRefreshedEvent event) {

    }
}
