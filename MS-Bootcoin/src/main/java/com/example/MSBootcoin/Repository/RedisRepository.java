package com.example.MSBootcoin.Repository;


import com.example.MSBootcoin.Domain.Bootcoin;

import java.util.Map;

public interface RedisRepository {
    Map<String,Bootcoin> findAll();
    Bootcoin findById(String id);
    void save(Bootcoin bootcoin);
    void delete(String id);
}
