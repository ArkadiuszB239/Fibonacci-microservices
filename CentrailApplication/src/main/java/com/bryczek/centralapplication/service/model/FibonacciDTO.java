package com.bryczek.centralapplication.service.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FibonacciDTO {
    private Integer id;
    private Long value;
    private Long calculatedValue;
}
