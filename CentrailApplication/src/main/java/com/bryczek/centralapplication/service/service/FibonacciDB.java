package com.bryczek.centralapplication.service.service;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "fibonacci")
public class FibonacciDB {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "keyV")
    private Long keyV;

    @Column(name = "value")
    private Long value;
}
