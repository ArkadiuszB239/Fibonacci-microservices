package com.bryczek.centralapplication.service.service;

import com.bryczek.centralapplication.service.model.FibonacciDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class FiboDbService {

    private final FibonacciRepoDB fibonacciRepo;

    public List<FibonacciDTO> getValues() {
        List<FibonacciDB> fiboList = new ArrayList<>();
        fibonacciRepo.findAll().forEach(fiboList::add);
        return fiboList.stream()
                .map(v -> new FibonacciDTO(v.getId(), v.getKeyV(), v.getValue()))
                .collect(Collectors.toList());
    }

    public boolean checkIfExists(Long value) {
        return fibonacciRepo.findByKeyV(value).isPresent();
    }
}
